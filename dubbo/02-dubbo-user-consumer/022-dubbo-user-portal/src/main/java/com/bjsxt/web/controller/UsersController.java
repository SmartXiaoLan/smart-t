package com.bjsxt.web.controller;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public ModelAndView addUser(ModelAndView modelAndView, Users users) {
        this.userService.addUser(users);
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    @RequestMapping("/findAll")
    public ModelAndView findUser(ModelAndView modelAndView) {
        List<Users> userAll = userService.findUserAll();
        modelAndView.addObject("users", userAll);
        modelAndView.setViewName("showUser");
        return modelAndView;
    }

    @RequestMapping("/dropUser/{userid}")
    public ModelAndView delUser(ModelAndView modelAndView, @PathVariable Integer userid) {
        userService.dropUserById(userid);
        modelAndView.setViewName("redirect:/user/findAll");
        return modelAndView;
    }


}
