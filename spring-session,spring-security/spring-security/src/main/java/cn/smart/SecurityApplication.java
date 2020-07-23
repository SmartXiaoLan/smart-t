package cn.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Smart-T
 *
 * 1.对于没有配置过的SpringSecurity默认全部拦截，默认用户名为：user 密码自动生成。可以在配置文件中配置用户名密码
 *
 * Spring认证的相关类
 * @see org.springframework.security.core.userdetails.UserDetails
 * @see org.springframework.security.core.userdetails.UserDetailsService
 * @see org.springframework.security.core.userdetails.User
 *
 * 需要自定定义登录逻辑需要使用 UserDetailsService 接口 同时还需要使用
 * @see org.springframework.security.crypto.password.PasswordEncoder 这个密码解析器自定义逻辑必须使用
 * @see org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder 官方推荐使用该实现方式作为密码解析器
 *  该解析器实现Hash算法实现的单向加密(只可以加密不可以解密)
 *
 */
@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
    }
}
