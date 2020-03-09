package cn.smart.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 自定义全局异常处理--3
 * SimpleMappingExceptionResolver
 */
//@Configuration
public class GlobalException2 {

    /**
     * 方法返回值必须是SimpleMappingExceptionResolver
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        /**
         * 参数一：异常类型，全限定路径
         * 参数二：视图名称
         */
        properties.put("java.lang.NullPointerException","NullError2");
        properties.put("java.lang.ArithmeticException","mathError2");
        resolver.setExceptionMappings(properties);
        return resolver;
    }

}
