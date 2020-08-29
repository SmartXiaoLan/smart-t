package cn.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


/**
 * @author Smart-T
 *
 * 文档地址:https://docs.spring.io/spring-security/site/docs/5.2.6.RELEASE/reference/htmlsingle/#cors
 *
 * 注意：
 *      该跨域配置方式建议使用在测试环境。
 *      推荐的服务端跨域是Nigix
 *
 *      ===========================待完善========================
 *
 */
//@Configuration
public class CorsSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 跨域配置
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("此处填写接受跨域的主站或IP","http://127.0.0.1:80","https://shaoteemo.com"));
        configuration.setAllowedMethods(Arrays.asList("此处填写接受跨域的请求方式","GET","POST","OPTIONS"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //开启跨域
        http.cors();

        http.csrf().disable();
    }
}