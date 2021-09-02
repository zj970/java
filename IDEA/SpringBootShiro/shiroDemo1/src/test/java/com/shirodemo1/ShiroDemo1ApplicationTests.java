package com.shirodemo1;

import com.shirodemo1.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroDemo1ApplicationTests {

    @Autowired
    UserServiceImpl userService;


    @Test
    void contextLoads() {
        System.out.println(userService.queryUserName("李白"));
    }

}
