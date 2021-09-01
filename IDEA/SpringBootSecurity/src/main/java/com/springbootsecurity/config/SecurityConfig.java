package com.springbootsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpSession;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常应该从数据库中读取
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("vip2","vip3")
                .and()
                .withUser("root").password("root").roles("vip1","vip2","vip3")
                .and()
                .withUser("zj").password("123456").roles("vip1");
    }

    //链式编程 基于建造者模式
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");


        //没有权限默认到登录页面
        http.formLogin();



    }
}
