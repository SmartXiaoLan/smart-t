package cn.smart.handler;

import cn.smart.service.impl.AuthorizationUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Smart-T
 * 自定义成功处理器可以跳转非本站的资源。但需要实现
 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler
 *
 * 通过
 * @see SecurityContextHolder 可以获得
 * @see Authentication 更准确的信息
 *
 *
 */
@Slf4j
//@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

//    @Autowired
    //认证成功后授权的方法
//    private AuthorizationUpdate authorizationUpdate;

    public MyAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //认证凭证
        User user = (User)authentication.getPrincipal();

        //认证成功后再授权的写法
//        this.authorizationUpdate.addAuthority(user.getUsername());

        log.info("用户:"+user.getUsername()+"  已跳转至主页 --> " + url);
        log.info("当前用户密码:"+user.getPassword()); //这个出于安全，不存储 == null
        log.info("用户拥有的权限:"+user.getAuthorities());

        response.sendRedirect(url);
    }
}
