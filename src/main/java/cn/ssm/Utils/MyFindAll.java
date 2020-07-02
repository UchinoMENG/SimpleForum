package cn.ssm.Utils;

import cn.ssm.domain.TitleContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class MyFindAll {
    private static ApplicationContext applicationContext;
    private static JdbcTemplate jdbcTemplate;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
        jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
    }
    public static List<TitleContext> findAll(String TableName){
        String sql = "select * from "+"`"+TableName+"`";
        RowMapper<TitleContext> rowMapper = new BeanPropertyRowMapper<TitleContext>(TitleContext.class);
        List<TitleContext> query = jdbcTemplate.query(sql, rowMapper);
        return query;
    }
    public static void InsertIntoContext(String TableName,String email,String context){
        String sql = "insert into "+"`"+TableName+"`"+" values(null,?,?)";
        jdbcTemplate.update(sql,email,context);
    }
}
