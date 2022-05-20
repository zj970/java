package com.shirodemo1.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {


    //ShiroFilterFactoryBean 过滤的对象 3
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager ){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
         *   anno:无需认证就可以访问
         *   authc:必须认证才可以访问
         *   user:必须拥有 记住我 功能才能用
         *   perms:拥有对某个资源的权限才能访问
         *   role；拥有某个角色权限才能访问
         *         filterChainDefinitionMap.put("/user/add","authc");
         *         filterChainDefinitionMap.put("/user/update","authc");
         * */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        //授权
        filterChainDefinitionMap.put("/user/add","perms[user:add]");
        filterChainDefinitionMap.put("/user/update","perms[user:update]");



        filterChainDefinitionMap.put("/user/*","authc");
        System.out.println(filterChainDefinitionMap);

        //如果没有权限登录
        bean.setLoginUrl("/toLogin");
        //未授权页面
        bean.setUnauthorizedUrl("/Unauth");

        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        return bean;
    }


    //defaultWebSecurityManager 管理对象 2
    @Bean(name = "getDefaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm 对象， 需要自定义 1
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }


    //整合shiroDialect: 用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
