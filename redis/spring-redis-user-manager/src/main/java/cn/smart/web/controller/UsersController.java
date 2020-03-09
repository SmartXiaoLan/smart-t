package cn.smart.web.controller;

import cn.smart.pojo.Users;
import cn.smart.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user")
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * AddUser
     * @param users
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(Users users){
        this.usersService.addUser(users);
        return "<h1 style='color :green'>Add Success!</h1>";
    }

    /**
     * Query user by id
     * @param modelAndView
     * @param userid
     * @return
     */
    @RequestMapping("/findUserById")
    public ModelAndView queryUser(ModelAndView modelAndView , Integer userid){
        if (userid != null) modelAndView.addObject("user",this.usersService.queryUserById(userid));
        modelAndView.setViewName("showUser");
        return modelAndView;
    }


    /**
     * Modify user by id
     * @param modelAndView
     * @param users
     * @return
     */
    @RequestMapping("/updateUser")
    public ModelAndView modifyUser(ModelAndView modelAndView , Users users){
        if (users.getUserid() != null)
            this.usersService.modifyUserById(users);
        modelAndView.setViewName("redirect:/findUser");
        return modelAndView;
    }



}
