package com.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    //没有实体类，数据库中的东西，怎么获取 ？ Map
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from admin";
        List<Map<String,Object>> listMas = jdbcTemplate.queryForList(sql);
        return  listMas;
    }

    //增加
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into admin(name,password) values ('周阿健',123456)";
        jdbcTemplate.update(sql);
        return "redirect:/addUser";
    }

    //修改
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update admin set name = ?,password = ? where id = "+id;
        //封装
        Object[] objects = new Object[2];
        objects[0] = "李白";
        objects[1] = "1234597";
        jdbcTemplate.update(sql,objects);
        return "redirect:/updateUser";
    }
    //删除
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from admin where id =?";
        jdbcTemplate.update(sql,id);
        return "redirect:/deleteUser";
    }
}
