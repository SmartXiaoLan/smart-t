package cn.smart.util;

import cn.smart.param.ConstantParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 传统J2EE响应的工具简单封装
 *
 * @author Smart-T
 * @since 16/08/2020
 */
public class ResponseMessageUtil {

    /**
     *
     * @param responseCode 响应码
     * @param response 响应对象
     * @param msg 消息
     * @throws IOException IO异常
     */
    public static void defaultResponseJson(int responseCode , HttpServletResponse response , String msg) throws IOException {
        String responseJson = JsonUtils.objectToJson(new ResponseEntity<String>(msg, HttpStatus.valueOf(responseCode)));
        response.setStatus(responseCode);
        response.setContentType(ConstantParam.RESPONSE_JSON_APPLICATION);
        response.getWriter().write(responseJson);
    }

}
