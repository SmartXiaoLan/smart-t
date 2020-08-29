package cn.smart.config;

import cn.smart.filter.MyFilter;
import cn.smart.handler.*;
import cn.smart.param.ConstantParam;
import cn.smart.service.impl.UserDetailsServiceImpl;
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
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

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

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PersistentTokenRepository tokenRepository;

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


        //自定义登录入口点
        http.httpBasic().authenticationEntryPoint(new MyAuthenticationEntryPoint());


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
//                .antMatchers("/login.html", "/fail.html").permitAll() //要赋予所有访问权的url

                //access的方式实现上面的语句
                .antMatchers("/login.html","/fail.html").access("permitAll")

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
//                .antMatchers("/mainA.html").hasAnyRole("aDMIN", "ADMIN")

                //access的方式实现上面的语句
//                .antMatchers("/mainA.html").access("hasRole('admin')")

                //IP判断
//                .antMatchers("/mainA.html").hasIpAddress("127.0.0.1")


                .anyRequest().authenticated() //所有请求都必须认证才可以访问
                //access()结合自定义方法的权限控制 , 与上面的代码类似
//                .anyRequest().access("@customAccessServiceImpl.hasPermission(request,authentication)")

        ;

        //RememberMe(优先内存中的Token)
        /*http.rememberMe()
                .tokenValiditySeconds(15) //token有效期
                .rememberMeParameter(ConstantParam.MY_DEFAULT_REMEMBER_ME_KEY)  //修改默认记住我键名
                .userDetailsService(this.userDetailsService) //用户登录逻辑对象
                .tokenRepository(this.tokenRepository); //自定义Token存储方式*/


        //关闭csrf防护否则上面的逻辑走不到
        http.csrf().disable();


        //退出登录
        /*
            重要的类 LogoutFilter
         */
        http.logout()
//                .invalidateHttpSession(true) //清除Session对象，默认True
//                .addLogoutHandler()
//                .logoutUrl("/user/logout") //一定义推出登录URL
//                .logoutSuccessHandler(new MyLogoutSuccessHandler())  //自定义退出登录成功处理器
//                .deleteCookies("JSESSIONID","[OtherKey]") //需要删除的Cookie
//                .clearAuthentication(true) //清除认证信息 ，默认为true
                .logoutSuccessUrl("/login.html"); //推出成功后跳转URL


        //异常处理
        http.exceptionHandling()
                //访问受限
                .accessDeniedHandler(this.accessDeniedHandler);
    }

    /*@Bean
    //配置tokenRepository配置类。记住我Token存储方式
    public PersistentTokenRepository  getPersistentTokenRepository(){

        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(this.dataSource);

        //在项目启动时创建rememberMe的表。第二次启动请注释此代码。
        *//*
            会在数据库中创建一个：persistent_logins
            的表里面包含字段有
                username：用户名
                series：主键
                token：token令牌
                last_used：最后登录使用时间

         *//*
//        jdbcTokenRepository.setCreateTableOnStartup(true);

        return jdbcTokenRepository;
    }*/
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