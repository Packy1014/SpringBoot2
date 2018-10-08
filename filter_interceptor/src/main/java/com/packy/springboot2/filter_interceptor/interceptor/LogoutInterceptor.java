package com.packy.springboot2.filter_interceptor.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutInterceptor implements HandlerInterceptor {
    //进入controller方法之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LogoutInterceptor----->preHandle");
        String username = request.getParameter("username");
        return "packy".equals(username) && HandlerInterceptor.super.preHandle(request, response, handler);
    }

    //调用完controller之后，视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("LogoutInterceptor----->postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //全部完成之后，一般用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("LogoutInterceptor----->afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
