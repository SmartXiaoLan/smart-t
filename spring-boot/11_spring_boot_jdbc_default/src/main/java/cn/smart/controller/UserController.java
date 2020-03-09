package cn.smart.controller;

import cn.smart.pojo.User;
import cn.smart.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    /*@Autowired
    private DataSource source;

    @GetMapping({"","/inf"})
    @ResponseBody
    public String showDataSource(){
        System.out.println(source.getClass().getPackage());
        return "ok";
    }*/

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(User user){
        try{
            this.userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return "forward:/page/error";
        }
        return "redirect:/user/findUserAll";
    }

    /**
     * 查询所有用户
     * @param modelAndView
     * @return
     */
    @GetMapping("/findUserAll")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<User> list = this.userService.findUserAll();
        modelAndView.addObject("users",list);
        modelAndView.setViewName("forward:/page/show");
        return modelAndView;
    }

    /**
     * 预更新用户信息方法
     * @param modelAndView
     * @return
     */
    @GetMapping("/preUpdateUser")
    public ModelAndView updateById(ModelAndView modelAndView,Integer id){
        User user = this.userService.findUserById(id);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("forward:/page/updateUser");
        return modelAndView;
    }

    /**
     * 更新用户
     * @param modelAndView
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public ModelAndView updateUserById(ModelAndView modelAndView,User user){
        this.userService.modifyUser(user);
        modelAndView.setViewName("redirect:/user/findUserAll");
        return modelAndView;
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @GetMapping("/deleteUser")
    public String deleteUser(Integer id){
        this.userService.deleteUser(id);
        return "redirect:/user/findUserAll";
    }
}
