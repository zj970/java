package com.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class SpringBootDemoApplicationTests {



    //自动注入数据
    @Autowired
    DataSource dataSource;//class com.zaxxer.hikari.HikariDataSource最快的数据源

    @Test
    void contextLoads() throws SQLException {
        //查看一下默认的数据源
        System.out.println(dataSource.getClass()+"+++++++++++++");

        //获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println("+++++++++++++"+connection);

        //xxxx Template: SpringBoot已经配置好模板bean,拿来即用 CRUD

        //关闭
        connection.close();
    }

}
