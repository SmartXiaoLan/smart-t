package cn.smart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  处理请求
 */
@RestController //== @Controller+@ResponseBody直接返回JSON字符串
public class HelloWorldController {

    @RequestMapping("/index")
    public  String showHelloWorld(){
        return "Hello,Spring Boot!😘";
    }

    @GetMapping("/indexGet")
    public  String showHelloWorldGet(){
        return "Hello,Spring Boot!😘";
    }

    @PostMapping("/indexPost")
    public  String showHelloWorldPost(){
        return "Hello,Spring Boot!😘";
    }

}
