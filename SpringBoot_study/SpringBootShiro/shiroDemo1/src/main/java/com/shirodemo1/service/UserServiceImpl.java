package com.shirodemo1.service;

import com.shirodemo1.mapper.UserMapper;
import com.shirodemo1.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserName(String name) {
        return userMapper.queryUserName(name);
    }
}
