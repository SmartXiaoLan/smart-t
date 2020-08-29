package cn.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * csrf防护的处理
 *  需要有_csrf服务器提供的键，才可以已完成见thymeleaf
 *
 * @author Smart-T\
 */
//@Configuration
public class CSRFSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //表单认证
        http.formLogin()
                .loginProcessingUrl("/login")
                .successForwardUrl("/user/toMain")
                .loginPage("/showLogin");

        //url拦截
        http.authorizeRequests()
                .antMatchers("/showLogin").permitAll()
                .anyRequest().authenticated();

//        http.csrf().disable();

    }

//    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
