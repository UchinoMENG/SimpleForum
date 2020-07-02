package cn.ssm.controller;

import cn.ssm.domain.ResultMsg;
import cn.ssm.domain.Watchtitle;
import cn.ssm.service.WatchTitleServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TItleAndUserController {
    @Autowired
    private WatchTitleServiec watchTitleServiec;
    @ResponseBody
    @RequestMapping(value = "/watchTitleCheck", method = RequestMethod.POST)
    public ResultMsg WatchTitle(HttpServletRequest request) {
        String title = request.getParameter("title");
        String email = request.getParameter("email");
        System.out.println("email:"+email);
        boolean b = watchTitleServiec.IsHave(email, title);
        if (b){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
    @ResponseBody
    @RequestMapping(value = "/checkSubmit", method = RequestMethod.PUT)
    public ResultMsg clickWatchButton(HttpServletRequest request){
        String title = request.getParameter("title");
        String email = request.getParameter("email");
        System.out.println("关注按钮执行了吗");
        watchTitleServiec.InsertWatch(email,title);
        return ResultMsg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/checkSubmit", method = RequestMethod.DELETE)
    public ResultMsg clickWatchButton2(HttpServletRequest request){
        String title = request.getParameter("title");
        String email = request.getParameter("email");
        watchTitleServiec.DeleteWatch(email,title);
        return ResultMsg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/checkSubmit", method = RequestMethod.GET)
    public ResultMsg getAllWatch(HttpServletRequest request){
        String email = request.getParameter("email");
        List<Watchtitle> allWatch = watchTitleServiec.getAllWatch(email);
        return ResultMsg.success().add("object",allWatch);
    }
}
