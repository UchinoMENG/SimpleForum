package cn.ssm.controller;
        import cn.ssm.Utils.MyFindAll;
        import cn.ssm.Utils.MyQuery;
        import cn.ssm.domain.Title;
        import javax.websocket.*;
        import javax.websocket.server.ServerEndpoint;
        import java.io.IOException;
        import java.net.URLDecoder;
        import java.util.List;
        import java.util.concurrent.ConcurrentHashMap;
        import java.util.concurrent.CopyOnWriteArraySet;
@ServerEndpoint("/webSocket")
public class WebSocketController {
    private  CopyOnWriteArraySet<WebSocketController> Con_temp;
    private static ConcurrentHashMap<String,CopyOnWriteArraySet<WebSocketController>> arraySet = new ConcurrentHashMap<>(); //存放每一个标题的的WebScoketServer对象，线程安全
    private String title;
    private Session session;
    private static MyQuery myQuery = new MyQuery();

    static {
        System.out.println(arraySet);
        List<Title> allTitle = myQuery.getAllTitle();
        for (Title title : allTitle) {
            arraySet.put(title.getTitleName(), new CopyOnWriteArraySet<WebSocketController>());
        }
//        new Thread(()->{
//            List<Title> allTitle = myQuery.getAllTitle();
//            for (Title title : allTitle) {
//                arraySet.put(title.getTitleName(), new CopyOnWriteArraySet<WebSocketController>());
//            }
//            System.out.println(arraySet.size());}).start();
//            new Thread(()->{
//                titleService.addTitle("1111111");}).start();
//        new Thread(()-> {
//            List<Title> all = titleService.findAll();
//            for (Title title : all) {
//                arraySet.put(title.getTitleName(), new CopyOnWriteArraySet<WebSocketController>());
//            }
//        }).start();
    }
    /**
     * 连接成功
     * @param session 会话信息
     */
    @OnOpen
    public void onOpen(Session session) {
        //以下sout为控制台测试
//        System.out.println(session.getQueryString());
        title = session.getQueryString().split("=")[1];
        try {
            title = URLDecoder.decode(title, "utf-8");
            System.out.println("decode:"+title);
        }
        catch (Exception e){
            e.printStackTrace();
        }

//        System.out.println(title);
//        System.out.println(arraySet.get(title));
        if(arraySet.get(title)!=null){
            System.out.println("已经存在");
            Con_temp = arraySet.get(title);
        }
        else{
            System.out.println("不存在");
            Con_temp = new CopyOnWriteArraySet<>();
            arraySet.put(title,Con_temp);
        }
        Con_temp.add(this);
        System.out.println(arraySet);
        System.out.println("加入了一个"+Con_temp.size()+"    "+arraySet.get(title).size());
        this.session =session;
//        this.addOnlineNum();
//        System.out.println("有一个新连接加入，当前在线 "+this.getOnLineNum()+" 人");
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        arraySet.get(title).remove(this);
        System.out.println("这是OnClose方法");
//        this.subOnlineNum();
//        System.out.println("有一个连接断开，当前在线 "+this.getOnLineNum()+" 人");
    }

    /**
     * 连接错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.err.println("OnError发生错误！");
        error.printStackTrace();
    }

    /**
     * 发送消息,不加注解，自己选择实现
     * @param msg
     * @throws IOException
     */
    public void onSend(String msg) throws IOException {
        System.out.println("这是OnSend方法");
        this.session.getBasicRemote().sendText(msg);
    }

    /**
     * 收到客户端消息回调方法
     * @param session
     * @param msg
     */
    @OnMessage
    public void onMessage(Session session, String msg) {
//        System.out.println("OnMessage中的："+session.getQueryString());
        System.out.println("这是OnMessage方法");
//        System.out.println("hahahahah");
        System.out.println("title:"+title);
        System.out.println("消息监控："+msg);
        String[] split = msg.split("&");
        String email = split[0].split("=")[1];
        String context = split[1].split("=")[1];
        MyFindAll.InsertIntoContext(title,email,context);
//        System.out.println(Con_temp);
        System.out.println("web中下游"+Con_temp.size());
        for (WebSocketController webScoketServer : Con_temp) {
//            System.out.println("执行了吗");
            try {
                webScoketServer.onSend(msg);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

}
