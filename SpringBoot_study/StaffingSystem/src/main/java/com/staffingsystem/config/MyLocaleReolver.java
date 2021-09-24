package com.staffingsystem.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleReolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的原参数
        String language = request.getParameter("l");
        System.out.println("获取的参数======>"+language);
        Locale locale = Locale.getDefault();//如果没有就使用默认的

        //如果请求的连接携带参数不为空
        if (!StringUtils.isEmpty(language)){
            //zh_CN分割
            String[] split = language.split("_");
            //国家地区
           return new Locale(split[0],split[1]);
        }
        return locale;
    }


    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
