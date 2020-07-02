package cn.ssm.controller;

import cn.ssm.Utils.MyFindAll;
import cn.ssm.Utils.MyQuery;
import cn.ssm.domain.PublicTitleAndUser;
import cn.ssm.domain.ResultMsg;
import cn.ssm.domain.Title;
import cn.ssm.domain.TitleContext;
import cn.ssm.service.PublicTitleAndUserService;
import cn.ssm.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TitleController {
    private MyQuery myQuery = new MyQuery();
    @Autowired
    private TitleService titleService;
    @Autowired
    private ResultMsg resultMsg;
    @Autowired
    private PublicTitleAndUserService publicTitleAndUserService;
    @Autowired
    private PublicTitleAndUser publicTitleAndUser;
    @ResponseBody
    @RequestMapping(value = "/title",method = RequestMethod.GET)
    public ResultMsg getTitleAll(){
        List<Title> all = titleService.findAll();
        System.out.println(all);
        resultMsg.setFlag(true);
        resultMsg.setMsg("操作成功");
        resultMsg.add("object",all);
        return resultMsg;
    }
    @ResponseBody
    @RequestMapping(value = "/title",method = RequestMethod.POST)
    public ResultMsg addTitle(HttpServletRequest request){
        String title = request.getParameter("title");
        String email = request.getParameter("email");
        Title title1 = titleService.findTitle(title);
        if (title1==null) {
            titleService.addTitle(title);
            myQuery.CreateTable(title);
            publicTitleAndUser.setEmail(email);
            publicTitleAndUser.setPublicTitle(title);
            publicTitleAndUserService.InsertTitle(publicTitleAndUser);
            return ResultMsg.success();
        }
        else{
            return ResultMsg.failed();
        }
    }
    @ResponseBody
    @RequestMapping(value = "/titleContext",method = RequestMethod.GET)
    public ResultMsg getTitleContext(HttpServletRequest request){
        String title = request.getParameter("title");
        List<TitleContext> all = MyFindAll.findAll(title);
        if(all==null){
            return ResultMsg.failed();
        }
        return resultMsg.success().add("object",all);
    }
}
