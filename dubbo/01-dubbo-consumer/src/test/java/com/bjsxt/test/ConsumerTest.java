package com.bjsxt.test;

import com.bjsxt.service.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        UserService bean = cac.getBean(UserService.class);
        bean.test("bjsxt");
    }
}
