package cn.smart.controller;

import cn.smart.pojo.User;
import cn.smart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(User user){
        this.userService.addUser(user);
        return "<h1 style=\"color: red\">Add Success!</h1>";
    }

}
