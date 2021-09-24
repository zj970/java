package com.staffingsystem.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    //拦截器
    //之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的sessoin
        Object loginUser = request.getSession().getAttribute("loginUser");//取得用户的名字
        System.out.println("==========="+loginUser);
        if (loginUser==null){
            //没有登录
            request.setAttribute("message","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);//返回这个页面
            return false;
        }
        else{
            return true;
        }
    }

    //之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
