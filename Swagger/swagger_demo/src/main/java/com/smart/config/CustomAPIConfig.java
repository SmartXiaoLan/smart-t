package com.smart.config;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Sets;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.Operation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Smart-T
 * <p>
 * 自定义API文档
 * <p>
 * 适用于没办法加注解的场景
 */
@Component
public class CustomAPIConfig implements ApiListingScannerPlugin {
    @Override
    public List<ApiDescription> apply(DocumentationContext context) {
        //声明一个文档这个可以有多个相当于一个就是一个@Api
        Operation usernamePasswordOperation = new OperationBuilder(new CachingOperationNameGenerator())
                .method(HttpMethod.POST)
                .summary("summary")
                .notes("notes")
                .consumes(Sets.newHashSet(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) // 接收参数格式
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE)) // 返回参数格式
                .tags(Sets.newHashSet("这是什么鬼打开api看看就知道了"))
                //传入参数文档定义
                .parameters(Arrays.asList(
                        //一个对象就表示一个传入参数
                        new ParameterBuilder()
                                .description("用户名")
                                .type(new TypeResolver().resolve(String.class))
                                .name("username")
                                .defaultValue("admin")
                                .parameterType("query")
                                .parameterAccess("access")
                                .required(true)
                                .modelRef(new ModelRef("string"))
                                .build(),
                        new ParameterBuilder()
                                .description("密码")
                                .type(new TypeResolver().resolve(String.class))
                                .name("password")
                                .defaultValue("admin")
                                .parameterType("query")
                                .parameterAccess("access")
                                .required(true)
                                .modelRef(new ModelRef("string"))
                                .build()
                ))
                .responseMessages(Collections.singleton(
                        new ResponseMessageBuilder().code(200).message("登录成功")
                                //Model模型？？？
                                /*.responseModel(new ModelRef(
                                        "com.smart.controller.People2Controller")
                                )*/.build()))
                .responseMessages(Collections.singleton(
                        new ResponseMessageBuilder().code(403).message("验证码不正确")
                                .build()))
                .responseMessages(Collections.singleton(
                        new ResponseMessageBuilder().code(403).message("Bad credentials")
                                .build()))
                .responseMessages(Collections.singleton(
                        new ResponseMessageBuilder().code(500).message("内部错误!")
                                .build()))

                .build();

        //装载一个模块
        ApiDescription loginApiDescription = new ApiDescription("login", "/login", "这是什么显示在",
                //这里面可以放多个接口
                Arrays.asList(usernamePasswordOperation), false);

        //将模块放入显示列表
        return Arrays.asList(loginApiDescription);
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return DocumentationType.SWAGGER_2.equals(delimiter);
    }
}
