package com.swaggerdemo.controller;


import com.swaggerdemo.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    //只要我们的接口中，返回值中存在实体类，它就会被扫描到Swager中
    @PostMapping(value = "/user")
    public User user()
    {
        return new User();
    }

    //Operation接口 不是放在类上的
    @ApiOperation("Hello控制类接口")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    @ApiOperation("post测试类")
    @PostMapping(value = "/post")
    public User post(@ApiParam("用户名")User user){
        int i = 5/0;
        return user;
    }
}
