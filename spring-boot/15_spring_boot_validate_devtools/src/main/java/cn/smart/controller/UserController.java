package cn.smart.controller;

import cn.smart.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
@RequestMapping("/user")
//非实体类数据校验
@Validated
public class UserController {

    @RequestMapping("/addUser")
    public ModelAndView addUser(@ModelAttribute("uuu") @Validated User user , BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()){
            /*List<ObjectError> list = result.getAllErrors();
            for (ObjectError err : list){
                FieldError fieldError = (FieldError) err;
                System.out.println(fieldError.getField() + "====" + fieldError.getDefaultMessage());
            }*/
            (modelAndView).setViewName("addUser");
            return modelAndView;
        }
        System.out.println(user);
        modelAndView.setViewName("ok");
        return modelAndView;
    }


    @PostMapping("/findUser")
    public String findUser(/*非实体类数据校验*/@NotBlank(message = "{username.notnull}") String username){
        System.out.println(username);
        return "ok";
    }

}
