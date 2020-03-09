package cn.smart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.smart.mapper")//指定扫描接口与映射配置文件
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
