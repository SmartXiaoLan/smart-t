package cn.smart;

import cn.smart.filter.SecondFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan //①在spring Boot 启动时会扫描@WebServlet,@WebFilter 注解，并将该类实例化
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class,args);
    }

    //第二种
    @Bean
    public FilterRegistrationBean<SecondFilter> getFilterRegistrationBean(){
        FilterRegistrationBean<SecondFilter> bean = new FilterRegistrationBean<>(new SecondFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
}
