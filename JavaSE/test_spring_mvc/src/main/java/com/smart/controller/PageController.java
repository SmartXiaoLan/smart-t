package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping("/welcome")
    public ModelAndView indexShow(ModelAndView modelAndView){
        modelAndView.addObject("msg",123);
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }
}
