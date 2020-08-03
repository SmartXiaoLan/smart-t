package cn.smart.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    /**
     * 自定义登录逻辑实现
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("登录认证逻辑执行！");



        //1.查询数据库判断用户名是否存在

        if (!username.equals("admin"))
            throw new UsernameNotFoundException("用户名不存在!");
        //2.把查询出来的密码解析,或直接吧password放到构造方法中
        //password就是数据库中加密过后的密码
        String password = this.encoder.encode("123");


        //返回用户名，密码，权限列表
        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_ADMIN,/main.html"));//access()结合自定义方法的权限控制添加/main.html

        //认证成功后再授权的写法
//        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_ADMIN"));
    }
}

/*
    security推荐的角色命名:ROLE_<角色名>。角色与权限区别主要在于是否ROLE_开头
 */