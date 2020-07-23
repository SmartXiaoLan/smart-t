package cn.smart.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Smart-T
 *
 * 配合自定义认证成功/失败Handler可以实现登陆前的一些验证
 * 如：常用验证码的前置校验...
 *
 */
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //这里处理一些事情

        //放行
        filterChain.doFilter(request,response);
    }
}
