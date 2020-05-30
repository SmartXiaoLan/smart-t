package cn.smart.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 更换序列化器需要所有服务都使用相同的序列化器
 *
 * 默认的序列化器：org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration#setRedisConnectionFactory(org.springframework.beans.factory.ObjectProvider, org.springframework.beans.factory.ObjectProvider)
 *
 */
@Configuration
public class RedisSessionConfig {

    /*
        更换默认的序列化器
     */
    @Bean("springSessionDefaultRedisSerializer")
    public RedisSerializer<?> defaultSerializer(){
        return getSerializer();
    }

    /*
        定义序列化器
     */
    private RedisSerializer<?> getSerializer(){
        return new GenericJackson2JsonRedisSerializer();
    }

}
