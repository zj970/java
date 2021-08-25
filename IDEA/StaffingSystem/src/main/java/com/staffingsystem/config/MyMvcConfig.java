package com.staffingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //首页控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");//映射到

    }

    //自定义的国际化组件 加载本地的解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleReolver();
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        //addPathPatterns拦截页面 excludePathPatterns忽略拦截页面
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")//增加拦截页面
                .excludePathPatterns("/index.html", "/", "/user/login","/css/*","/js/*","/img/*");//忽略拦截页面
    }
}
