package cn.smart;

import cn.smart.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan//①在spring Boot 启动时会扫描@WebServlet,@WebFilter,@WebListener 注解，并将该类实例化
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class,args);
    }

    @Bean
    public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean<>(new SecondListener());
        return bean;
    }

}
