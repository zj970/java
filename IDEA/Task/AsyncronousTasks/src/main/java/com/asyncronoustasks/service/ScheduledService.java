package com.asyncronoustasks.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduledService {

    Date data = new Date();//位置很重要
    //在一个特定时间执行这个方法 Timer

    //cron 表达式
    //秒 分 时 日 月 周几
    @Scheduled(cron = "0 * * * * 0-7")
    public void hello(){
        System.out.println("你被执行了");
        System.out.println(data);
    }
}
