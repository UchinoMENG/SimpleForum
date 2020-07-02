package cn.ssm.Utils;

import cn.ssm.dao.TitleMapper;
import cn.ssm.domain.Title;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyQuery {
    private ApplicationContext ac;
    private TitleMapper titleMapper;
    {
        ac = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
        titleMapper = ac.getBean("titleMapper",TitleMapper.class);
    }
    public List<Title> getAllTitle(){
        return titleMapper.selectByExample(null);
    }
    public void CreateTable(String titleName){
        titleMapper.createTableTitle(titleName);
    }
}
