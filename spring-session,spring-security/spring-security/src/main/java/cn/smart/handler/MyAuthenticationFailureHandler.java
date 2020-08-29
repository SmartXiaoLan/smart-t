package cn.smart.handler;

import cn.smart.util.ResponseMessageUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Smart-T
 *
 * 自定义错误处理器
 *
 * 此处可以根据不同的处理类型，响应不同的消息。
 * 也应该这么做，给与用户不同的提示减少后期麻烦。
 *
 *
 */

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private String url;

    public MyAuthenticationFailureHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        //一个密码错误自定义提示
        if (exception instanceof BadCredentialsException){
            //添加返回JSON消息
//            ResponseMessageUtil.defaultResponseJson();
            return;
        }
        //……

        response.sendRedirect(url);
    }
}
