package com.shirodemo1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {


    @RequestMapping({"/","index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,Shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        System.out.println("跳转登录页面");
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        System.out.println("进入到了登录验证方法");
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据 加密
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);//执行登录的方法
            return "index";
        }catch (UnknownAccountException uae) {//用户名不存在
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch(IncorrectCredentialsException ice){//密码不存在
            model.addAttribute("msg","密码错误");
            return "login";
        }



    }

    @RequestMapping("/Unauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权，无法访问页面";
    }

}
