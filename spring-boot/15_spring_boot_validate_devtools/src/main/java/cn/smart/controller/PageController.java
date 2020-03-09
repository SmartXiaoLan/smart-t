package cn.smart.controller;

import cn.smart.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 跳转页面方法
     * 解决异常的方式:可以在跳转页面的方法中注入一个User对象
     * 由于SpringMVC会将该对象放入到model中传递,key的名称会使用该对象的驼峰命名规则来作为Key
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    /**
     * @ModelAttribute("uuu")可以指定页面的参数变量名参数key的名称
     */
    public String showPage(@PathVariable String page , @ModelAttribute("uuu") User uuu/*user*/){
        return page;
    }


}
