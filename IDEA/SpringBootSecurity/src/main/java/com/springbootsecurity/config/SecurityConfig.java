package com.springbootsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //认证，springboot 2.1.x 可以直接使用
    //报错500，id="null" 密码编码
    //在Spring Secutiry 5.0+新增了很多的加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常应该从数据库中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip1","vip2","vip3")
                .and()
                .withUser("zj").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
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
        http.formLogin().usernameParameter("username").passwordParameter("pwd").loginPage("/usr/login");//loginPage()指定登录界面是哪一个，一定都要是POST请求
        //防止网站攻击：get,post
        http.csrf().disable();//关闭csrf功能，防止跨站请求伪造关闭，慎用！登录注销失败使用
        //注销功能开启，跳到首页
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能 cookie,默认保存两周，自定义接收前端的参数
        http.rememberMe().rememberMeParameter("remember");

    }
}
