package com.example.demo.cotroller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/zj")
    public String toStart(){
        return "/index"
    }

    //添加记录
    @PostMapping("/index")
    public String toAdd(User user) {
        userMapper.addUser(user);
        System.out.println(user);
        return "谢谢参与";
    }

}
