package com.localhost.test.jdbc;

import cn.ssm.Utils.MyFindAll;
import cn.ssm.domain.TitleContext;
import org.junit.Test;

import java.util.List;

public class jdbcTemplateTest {
    @Test
    public void test(){
        List<TitleContext> lala = MyFindAll.findAll("lala");
        for (TitleContext titleContext : lala) {
            System.out.println(titleContext);
        }
        System.out.println(lala);
    }
}
