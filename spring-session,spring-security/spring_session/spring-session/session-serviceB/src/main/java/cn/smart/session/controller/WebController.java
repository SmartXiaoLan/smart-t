package cn.smart.session.controller;

import cn.smart.session.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("serviceB")
public class WebController {

    @RequestMapping("getMsg")
    public String getMsg(HttpSession session){
        String msg = (String) session.getAttribute("msg");
        return msg;
    }


    /**
     * 获取Session中的User信息
     */
    @RequestMapping("/getUser")
    public User getUser(HttpSession session){
        return (User) session.getAttribute("user");
    }

}
