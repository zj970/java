package com.test.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService
@Component
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "购票成功";
    }
}
