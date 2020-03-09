package cn.smart.web.controller;

import cn.smart.pojo.Users;
import cn.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(ModelAndView modelAndView , Users user){
        this.userService.addUser(user);
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    /**
     * 查询全部用户
     * @return
     */
    @RequestMapping("/findUser")
    public String findUserAll(Model model){
        model.addAttribute("users",this.userService.findUserAll());
        return "showUser";
    }


}
