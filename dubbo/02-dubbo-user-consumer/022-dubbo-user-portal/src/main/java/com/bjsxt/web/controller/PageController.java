package com.bjsxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping("/index")
    public ModelAndView showIndex(ModelAndView modelAndView){
        modelAndView.addObject("msg","ModelAndView");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    /*@RequestMapping("/index")
    public String showIndex(){
        return "index";
    }*/

    @RequestMapping("/addUser")
    public ModelAndView showAddUser(ModelAndView modelAndView){
        modelAndView.setViewName("addUser");
        return modelAndView;
    }
}
