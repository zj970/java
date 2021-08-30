package com.springbootwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("com.springbootwx.mapper") //设置mapper接口的扫描包
@SpringBootApplication
public class SpringBootWxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWxApplication.class, args);
    }

}
