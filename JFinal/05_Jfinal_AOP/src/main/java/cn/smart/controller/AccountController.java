package cn.smart.controller;

import cn.smart.service.AccountService;
import com.jfinal.aop.Inject;

public class AccountController {

    @Inject
    AccountService service;  //此处会注入依赖对象

    public void index(){
        service.justDoIt();     //调用被注入对象方法
    }


}
/*
    特别注意：使用 Inject 注入的前提是使用 @Inject 注解的类的对象的创建是由 jfinal 接管的，
    这样 jfinal 才有机会对其进行注入。例如 Controller、Interceptor、Validator 的创建是 jfinal 接管的，
    所以这三种组件中可以使用 @Inject 注入。

    此外：注入动作可以向下传递。例如在 Controller 中使用 @Inject 注入一个 AaaService，
    那么在 AaaService 中可以使用 @Inject 注入一个 BbbService，如此可以一直向下传递进行注入.
 */