package com.asyncronoustasks.controller;


import com.asyncronoustasks.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello(){
        asyncService.hello();//停止5s
        return "ok";
    }
}
