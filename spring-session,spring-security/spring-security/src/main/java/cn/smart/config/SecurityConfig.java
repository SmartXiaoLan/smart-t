package cn.smart.config;

import cn.smart.filter.MyFilter;
import cn.smart.handler.MyAccessDeniedHandler;
import cn.smart.handler.MyAuthenticationFailureHandler;
import cn.smart.handler.MyAuthenticationSuccessHandler;
import cn.smart.param.ConstantParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author Smart-T
 * <p>
 * 自定义登录相关需要实现
 * @see WebSecurityConfigurerAdapter
 */
@Configuration
//开启方法(接口)注解权限
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义访问受限页面
    @Autowired
    private MyAccessDeniedHandler accessDeniedHandler;

    /**
     * 注入自定义逻辑的密码解析器
     *
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //自定义过滤器
        /*
            用法:
                需要定义一个Filter，最好使用继承OncePerRequestFilter
                然后转入余姚在那个过滤器之前或之后的该类的反射对象。
         */
//        http.addFilter().addFilterBefore().addFilterAfter();
        http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class);

        //一些常用的头信息，包括Xss简单防护等
        http.headers()
                .xssProtection();
        // 禁用缓存
//              .cacheControl();

        //认证
        http.formLogin()//自定义表单配置相关项
                .loginProcessingUrl("/login") //当发现访问/login时认为是登录，走执行自定义UserDetailsServiceImpl逻辑
//                .failureForwardUrl("/user/fail") //自定义登陆失败配置页面①
                .failureHandler(new MyAuthenticationFailureHandler("/fail.html"))
                .loginPage("/login.html")  //配置自定义登陆页面
                /*
                    根据源码下面的 successForwardUrl 只可以站内跳转。不适合前后端分离模式(需要自定义配置)
                    successHandler自定义成功处理器与之不可以共存
                 */
                .successForwardUrl("/user/toMain") //自定义成功处理器。此处是post请求①
//                .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com")) //自定义成功处理器
                .usernameParameter(ConstantParam.MY_DEFAULT_LOGIN_PARAMETER_USERNAME) //自定义用户名密码参数名
                .passwordParameter(ConstantParam.MY_DEFAULT_LOGIN_PARAMETER_PASSWORD);

        //授权
        //url拦截
        http.authorizeRequests()
                .antMatchers("/login.html", "/fail.html").permitAll() //要赋予所有访问权的url
                /*
                    antMatchers使用规则
                            ?  匹配一个字符
                            *  匹配0个或多个字符
                            ** 匹配0个或多个目录
                 */
                //静态资源放行
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                //后缀匹配
//                .antMatchers("/**/*.png").permitAll()

                //正则匹配
//                .regexMatchers(".+[.]jpg").permitAll()
                //下面表示该请求只接受POST方式提交，否则要求认证。也可以不写默认GET
//                .regexMatchers(HttpMethod.POST,"/user/test").permitAll()

                //当有项目访问前缀时推荐匹配（配置文件中有mvc.servlet.path）
//                .mvcMatchers("/user/test").servletPath("/smart").permitAll()
                .antMatchers("/smart/user/test").permitAll()


                //权限的判断
                //单个权限
//                .antMatchers("/mainA.html").hasAuthority("admin1")
                //多个权限匹配(只要有一个权限满足就就可以访问,只有都不具有才会阻止访问)
//                .antMatchers("/mainA.html").hasAnyAuthority("admin","admin1")


                //角色判断(不可以以ROLE_开头，注意区分大小写)
                //单个
//                .antMatchers("/mainA.html").hasRole("aDMIN")
                //多个
                .antMatchers("/mainA.html").hasAnyRole("aDMIN", "ADMIN")


                //IP判断
//                .antMatchers("/mainA.html").hasIpAddress("127.0.0.1")


                .anyRequest().authenticated() //所有请求都必须认证才可以访问
        ;


        //关闭csrf防护否则上面的逻辑走不到
        http.csrf().disable();


        //异常处理
        http.exceptionHandling()
                //访问受限
                .accessDeniedHandler(this.accessDeniedHandler);
    }
}

/*
    ================划重点=================
    权限控制的几个内置常量 路径：permitAll->access
            permitAll:全部允许访问
            denyAll:全部拒绝访问
            anonymous:匿名访问
            authenticated:被认证访问
            fullyAuthenticated正常登录访问才可以(记住我功能访问将会被拦截):完整的认证访问
            rememberMe:记住我可以访问
 */