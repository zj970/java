package com.ckf.login_wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ckf.login_wx.mapper")
@SpringBootApplication
public class LoginWxApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginWxApplication.class, args);
    }

}
