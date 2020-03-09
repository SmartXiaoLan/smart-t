package cn.smart.web.controller;

import cn.smart.pojo.Users;
import cn.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    @ResponseBody
    public Object insertUser(@RequestBody Users user){

        Map<String,Integer> map = new HashMap<>();

        try {
            this.userService.insertUser(user);
            map.put("code",200);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",500);
        }
        return map;
    }

    @RequestMapping("/selectUserAll")
    @ResponseBody
    public List<Users> selectUserAll(){
        return this.userService.selectUserAll();
    }

}
