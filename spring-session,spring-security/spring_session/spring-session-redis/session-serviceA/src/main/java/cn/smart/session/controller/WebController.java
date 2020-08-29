package cn.smart.session.controller;

import cn.smart.session.domain.Roles;
import cn.smart.session.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("serviceA")
public class WebController {

    @RequestMapping("/setMsg")
    public String setMsg(HttpSession session , String msg){
        session.setAttribute("msg",msg);
        return "OK";
    }

    /**
     * 获取User信息并保存到HttpSession中
     *
     */
    @RequestMapping("/addUser")
    public String addUser(HttpSession session , User user){
        user.setRoles(new Roles(111,"删除功能"));
        session.setAttribute("user",user);

        return "OK";
    }

}
