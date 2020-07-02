package cn.ssm.controller;

import cn.ssm.domain.PublicTitleAndUser;
import cn.ssm.domain.ResultMsg;
import cn.ssm.domain.User;
import cn.ssm.service.PublicTitleAndUserService;
import cn.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PublicTitleAndUserService publicTitleAndUserService;
//    @ResponseBody
//    @RequestMapping("/user")
//    public List<User> getAll(Model model){
//        return userService.getAll();
//    }
    @ResponseBody
    @RequestMapping(value ="/user",method = RequestMethod.GET)
    public ResultMsg getUser(User u){
        User user = userService.getUser(u);
        ResultMsg resultMsg = new ResultMsg();
        if(user==null){
            resultMsg.setMsg("该用户不存在");
            resultMsg.setFlag(false);
            resultMsg.add("Object",null);
        }
        else{
            if(u.getPassword().equals(user.getPassword())){
                return ResultMsg.success().add("Object",user);
            }
            else{
                resultMsg.setMsg("密码不正确");
                resultMsg.setFlag(false);
                resultMsg.add("Object",null);
            }
        }
        return resultMsg;
    }
    @ResponseBody
    @RequestMapping(value ="/user",method = RequestMethod.POST)
    public ResultMsg LoginUser(User u){
        User user = userService.getUser(u);
        ResultMsg resultMsg = new ResultMsg();
        if(user==null){
            userService.InsertUser(u);
            resultMsg.setFlag(true);
            resultMsg.setMsg("处理成功");
            resultMsg.add("Object",u);
        }
        else{
            resultMsg.setFlag(false);
            resultMsg.setMsg("用户已经存在");
            resultMsg.add("Object",u);
        }
        return resultMsg;
    }
    @ResponseBody
    @RequestMapping(value = "/titlePublisher",method = RequestMethod.GET)
    public ResultMsg getTitlePublisher(HttpServletRequest request){
        String title = request.getParameter("title");
        PublicTitleAndUser titleUser = publicTitleAndUserService.getTitleUser(title);
        return ResultMsg.success().add("object",titleUser);
    }
    @ResponseBody
    @RequestMapping(value = "/registerOkDIs")
    public void JustSleep(){
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
