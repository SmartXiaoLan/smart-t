package com.bjsxt;

import com.alibaba.dubbo.container.Main;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Start {

    public static void main(String[] args) {
        /*ConfigurableApplicationContext cac = new ClassPathXmlApplicationContext("spring/spring-dubbo.xml");
        cac.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //Main类下的main方法默认:classpath:/META-INF/spring/*.xml
        Main.main(args);

    }
}
