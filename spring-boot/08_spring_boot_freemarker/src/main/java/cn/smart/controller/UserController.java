package cn.smart.controller;

import cn.smart.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * FreeMarker视图控制器
 */
@Controller
public class UserController {

    @GetMapping("/index")
    public ModelAndView showUsers(ModelAndView view){
        List<User> list = new ArrayList<>();
        list.add(new User("admin",22,"Man"));
        list.add(new User("ZhangSan",42,"Woman"));
        list.add(new User("Lisi",12,"Man"));
        view.addObject("list",list);
        view.setViewName("userList");
        return view;
    }

}
