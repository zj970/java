package com.ckf.login_wx.servic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckf.login_wx.entity.User;
import com.ckf.login_wx.mapper.UserMapper;
import com.ckf.login_wx.servic.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
