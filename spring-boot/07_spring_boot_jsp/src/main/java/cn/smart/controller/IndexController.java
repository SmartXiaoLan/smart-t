package cn.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * JSP页面跳转Controller
 */
@Controller
public class IndexController {

    @GetMapping({"","/{index}"})
    public String indexPage(@PathVariable String index){
        return index;
    }

}
