package com.test.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service//放到容器中
public class UserService {
    //想拿到provide-server提供的票,要去注册中心拿到服务
    @DubboReference //引用，Pom坐标，可以定义路径相同的接口名
    TicketService ticketService;

    public  void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到=》" + ticket);
    }
}
