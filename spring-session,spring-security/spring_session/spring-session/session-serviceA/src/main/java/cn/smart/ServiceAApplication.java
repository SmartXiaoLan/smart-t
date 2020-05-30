package cn.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
//开启Redis Session支持
//@EnableRedisHttpSession
//设置Session失效时间等信息
/*
    如果要保证maxInactiveIntervalInSeconds在所有访问都生效需要在所有服务中
    添加相同的属性，并且设置相同的时间。

    否则会出现失效时间不一致的问题
 */
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5)
/*
    redisNamespace

    设置默认的前缀。

    该属性需要所有共享Session的服务都需要设置否则无效


 */
@EnableRedisHttpSession(redisNamespace = "mySpringSession")
public class ServiceAApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class,args);
    }
}
/*
    序列化器
        Spring Session 默认使用JDK的序列化器
 */