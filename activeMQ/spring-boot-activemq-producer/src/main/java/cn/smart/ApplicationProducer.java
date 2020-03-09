package cn.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
//开启消息队列
@EnableJms
public class ApplicationProducer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationProducer.class,args);
    }

}
