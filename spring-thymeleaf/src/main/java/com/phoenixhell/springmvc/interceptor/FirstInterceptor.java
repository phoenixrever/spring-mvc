package com.phoenixhell.springmvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 必须在spring mvc 配置文件里面 配置 <mvc:interceptor>
 * 在这里加 @Component 可以直接ref 引用bean 不用写bean 标签
 * 简单来说要么bean 注入并指定拦截器实现类 要么@Component 注入到容器种 ref指定拦截器
 * spring boot是因为帮我们都配置好了
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor-----------------");
        return true;
    }
}
