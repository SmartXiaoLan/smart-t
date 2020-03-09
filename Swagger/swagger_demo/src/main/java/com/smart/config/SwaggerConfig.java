package com.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

/**
 * @author Smart-T
 *
 * Swagger配置文件修改方式。
 *
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                //指定扫描的包(apis)
                .apis(RequestHandlerSelectors.basePackage("com.smart.controller"))
                //自定以注解不扫描的接口(apis)
                .apis(not(withMethodAnnotation(NotIncludeSwagger.class)))

                //Paths第二重过滤
                .paths(or(PathSelectors.regex("/people/.*"),PathSelectors.regex("/person/.*")))
                .build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("Swagger_Demo")
                .description("描述位置!")
                .version("0.0.1")
                .contact(new Contact("10086","10086.cn","10086.qq.com"))
                .build();
    }
}
