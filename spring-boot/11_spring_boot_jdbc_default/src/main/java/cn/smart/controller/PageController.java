package cn.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Smart-T
 *
 * 页面跳转Controller
 *
 */
@Controller
@RequestMapping("/page")
public class PageController {

    //页面跳转方法
    @GetMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

}
