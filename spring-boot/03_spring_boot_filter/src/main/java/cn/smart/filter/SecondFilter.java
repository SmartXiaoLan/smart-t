package cn.smart.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 第二种方式实现filter
 */
//@WebFilter(filterName = "SecondFilter" , urlPatterns = "/")
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入Filter...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("退出Filter...");
    }
}
