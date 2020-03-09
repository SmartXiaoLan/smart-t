package com.smart.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//指定注解使用的位置，下面的为方法上
@Target({ElementType.METHOD})
//表示该注解在运行时才被解析
@Retention(RetentionPolicy.RUNTIME)

public @interface NotIncludeSwagger {
}
