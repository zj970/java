package com.ckf.login_wx.controller;

import com.ckf.login_wx.entity.User;
import com.ckf.login_wx.servic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; /**
 * @author 安详的苦丁茶
 * @date 2020/4/30 13:39 */ @RestController
@RequestMapping("/test") public class UserController {

    @Autowired private UserService userService; /**
     * 查询全部
     * @return */ @GetMapping("/list") public Object list(){
        System.out.println("查询成功"); return userService.list();
    } /**
     * 根据id删除
     * @param id
     * @return */ @GetMapping("/delete") public boolean delete(Integer id){
        System.out.println("删除成功"); return userService.removeById(id);
    } /**
     *  根据id查询
     * @param id
     * @return */ @GetMapping("/byid") public Object byid(Integer id){
        System.out.println("查询成功"); return userService.getById(id);
    } /**
     *  修改
     * @param user
     * @return */ @PostMapping("/update") public boolean update(@RequestBody User user){
        System.out.println("修改成功"); return userService.updateById(user);
    } /**
     * 添加
     * @param user
     * @return */ @PostMapping("/add") public boolean add(@RequestBody User user){
        System.out.println("添加成功"); return userService.save(user);
    }

}
