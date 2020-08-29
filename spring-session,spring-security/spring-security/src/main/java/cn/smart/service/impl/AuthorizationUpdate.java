package cn.smart.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Smart-T
 *
 * 问题引出：
 *      Security在认证并授权通过后，用户登录状态下，管理员动态的赋予权限需要退出 重新登录 获取权限列表才可以使用。
 *
 * 解决方案：
 *
 * 认证通过后动态的更新权限列表，注意退出登陆后非数据库中的权限将丢失。
 *
 * 该类一般可以在登录成功后再赋予账户权限
 *
 * 通过
 * @see SecurityContextHolder 可以获取权限相关的信息
 *
 * 通过User查询认证时候附带的权限将不变，最终权限还是通过SecurityContextHolder查看
 *
 * *-视项目而定一般不推荐使用-*
 *
 */
@Slf4j
//@Component
public class AuthorizationUpdate {

    public boolean addAuthority(String authName){
        try {
            // 获取成功登录的认证信息
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            // 生成新的认证信息
            Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,admin"));
            /*
                使用Apache字符串处理工具可以去除[]符号，详见API
             */
//            String strip = StringUtils.strip("abc  234", "23");
            // 重置认证信息
            SecurityContextHolder.getContext().setAuthentication(newAuth);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
