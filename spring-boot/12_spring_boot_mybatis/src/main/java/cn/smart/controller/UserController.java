package cn.smart.controller;

import cn.smart.pojo.User;
import cn.smart.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"","/user"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(User user){
        this.userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping({"","/findUserAll"})
    public ModelAndView showUsers(ModelAndView modelAndView){
        modelAndView.addObject("users",this.userService.findUsers());
        modelAndView.setViewName("/show");
        return modelAndView;
    }

    /**
     * 预更新用户
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping("/preUpdateUser")
    public ModelAndView preUpdateUser(Integer id ,ModelAndView modelAndView){
        modelAndView.addObject("user",this.userService.preUpdateUser(id));
        modelAndView.setViewName("/updateUser");
        return modelAndView;
    }

    @PostMapping("/updateUser")
    public ModelAndView updateUser(User user ,ModelAndView modelAndView){
        this.userService.modifyUserById(user);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping("/deleteUser")
    public ModelAndView dropUser(Integer id,ModelAndView modelAndView){
        this.userService.dropUserById(id);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }


}
