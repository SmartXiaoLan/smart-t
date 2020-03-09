package cn.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    /**
     * 默认自定义错误页面
     * @return
     */
    @RequestMapping("/showInfo")
    @ResponseBody
    public String showInfo(){
        String str = null;
        str.length();
        return "ok";
    }

    @RequestMapping("/showInfo2")
    @ResponseBody
    public String showInfo2(){
        int a = 1/0;
        return "ok";
    }

    /**
     * 自定义异常跳转---原始写法1
     * @param e
     * @return
     */
    /*@ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullPointExceptionHandler(Exception e ){
        //必须这样写，不可以依赖注入
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("err",e.toString());
        modelAndView.setViewName("NullError");
        return modelAndView;
    }*/

}
