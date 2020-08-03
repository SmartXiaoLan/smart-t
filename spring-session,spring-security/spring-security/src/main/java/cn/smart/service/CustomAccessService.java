package cn.smart.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Smart-T
 *
 * access()结合自定义方法的权限控制
 *
 * @since 03/08/2020
 */
public interface CustomAccessService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
