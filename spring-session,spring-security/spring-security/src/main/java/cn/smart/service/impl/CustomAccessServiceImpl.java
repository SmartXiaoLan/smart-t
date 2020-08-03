package cn.smart.service.impl;

import cn.smart.service.CustomAccessService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author Smart-T
 *
 * 自定义类结合access的实现类哦
 *
 * =================划重点==================
 * 数据库动态的权限控制可以使用该方式
 *
 * @since 03/08/2020
 */
@Service
public class CustomAccessServiceImpl implements CustomAccessService {
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        //获取当前用户的所有权限列表
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        //权限是否包含
        return authorities.contains(new SimpleGrantedAuthority(request.getRequestURI()));
    }
}
