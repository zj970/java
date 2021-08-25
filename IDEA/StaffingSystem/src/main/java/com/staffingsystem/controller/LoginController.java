package com.staffingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession httpSession)
    {

        //具体的业务
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            httpSession.setAttribute("loginUser",username);
            System.out.println(username+"=================="+password);
            return "redirect:/main.html";
        }else {
            //告诉用户，你登录失败了！
            System.out.println(username+"=================="+password);
            model.addAttribute("message","用户名或者密码错误");
            return "index";
        }
    }
}
