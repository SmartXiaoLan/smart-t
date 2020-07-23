package cn.smart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
//@RestController
@RequestMapping("/user")
public class LoginController {


    /*@RequestMapping("/login")
    public String login(){
        log.info("Login Is Access!");
        return "redirect:main.html";
    }*/

    /**
     * 主页面跳转方法
     *
     * @return
     */
    @PostMapping("/toMain")
    public String toMain(){
        log.info("toMain Is Access!");
        return "redirect:/main.html";
    }


    /**
     * 登陆失败跳转页面
     * @return
     */
    @PostMapping("/fail")
    public String fail(){
        log.info("fail-->Login Fail");
        return "redirect:/fail.html";
    }

    /**
     * 测试正则，mvc匹配
     * @return
     */
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
