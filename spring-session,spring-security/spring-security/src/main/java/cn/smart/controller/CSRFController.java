package cn.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Smart-T
 * @since 29/08/2020
 */
@Controller
public class CSRFController {

    @RequestMapping("/showLogin")
    public String showLogin(){
        return "login";
    }

}
