package com.springbootmybatis.controller;

import com.springbootmybatis.mapper.UserMapper;
import com.springbootmybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserMapper userMapper;

    //查询所有用户
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user:userList){
            System.out.println(user);
        }
        return userList;
    }

    //查询单个用户
    @GetMapping("/seletone/{id}")
    public User queryUser(@PathVariable("id") Integer id){
        User user = userMapper.queryUserById(id);
        return user;
    }

    //添加用户
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User("周健","123456"));
        return "ok";
    }

    //修改用户
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        userMapper.updateUser(new User(id,"韩信","123456"));
        return "ok";
    }

    //删除用户
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userMapper.deleteUser(id);
        return "ok";
    }

}
