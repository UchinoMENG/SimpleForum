package com.localhost.test.mybatis;

import cn.ssm.dao.TitleMapper;
import cn.ssm.dao.UserMapper;
import cn.ssm.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ApplicationContext.xml"})
public class mybatisTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TitleMapper titleMapper;
    @Test
    public void test1(){
        System.out.println(userMapper);
        List<User> users = userMapper.selectByExample(null);
        System.out.println("第一次循环");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("第二次循环");
        List<User> users1 = userMapper.selectByExample(null);
        for (User user : users1) {
            System.out.println(user);
        }
    }
    @Test
    public void test2(){
        Stack<Integer> ss = new Stack<>();
//        titleMapper.createTableTitle("对对对");
    }

    public static void main(String[] args) {
        Map<String ,Integer> map  = new HashMap<>();
        map.put("1",2);
        map.put("香蕉",2);
        map.put("2",1);
        map.put("苹果",1);
        map.put("3",3);
        map.put("菠萝",3);
        map.put("4",5);
        map.put("樱桃",5);
        Scanner in = new Scanner(System.in);
        int sum = 0;
        String str = in.next();
        while(!str.equals("0")){
            sum+=map.get(str);
            str = in.next();
        }
        System.out.println("花费的总价格为:"+sum);
    }
}
