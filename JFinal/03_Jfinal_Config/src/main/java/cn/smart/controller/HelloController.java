package cn.smart.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class HelloController extends Controller {

    /**
     * 当此注解加上后有原来的/hello/login变成/log
     */
    @ActionKey("/log")
    public void login(){
        render("login.html");
    }

}
