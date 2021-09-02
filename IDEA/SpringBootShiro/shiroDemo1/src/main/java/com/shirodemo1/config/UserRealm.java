package com.shirodemo1.config;

import com.shirodemo1.pojo.User;
import com.shirodemo1.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的UserRealm 需要继承AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权方法doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");

        //拿到当前用户登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();

        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证的方法doGetAuthenticationInfo");

        //用户名，密码，数据库中取
        //String name = "root";
        //String password = "123456";
        /*
        if (!userToken.getUsername().equals(name)){
            System.out.println("用户名异常");
            return null;//抛出异常UnknownAccountException
        }*/
        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
        //连接真实数据库
        User user =  userService.queryUserName(userToken.getUsername());
        if (user ==null){
            return null;//抛出异常UnknownAccountException
        }

        //密码认证，shiro做~
        //可以加密 MD5 MD5颜值加密
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
