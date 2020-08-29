package cn.smart.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * document_url:https://docs.spring.io/spring-security/site/docs/5.2.6.RELEASE/reference/htmlsingle/#tech-intro-auth-entry-point
 *
 * 登录入口点：
 *  该方式可以适用于前端的JSON未登录提示。
 *  默认的是跳转一个登录页面，但在实际的前后端完全分离中是没有必要的。
 *
 * @author Smart-T
 * @since 16/08/2020
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //这里处理返回响应JSON提示
    }
}
