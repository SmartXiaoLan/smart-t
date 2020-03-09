package cn.smart.controller;

import cn.smart.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class IndexController {

    @GetMapping({"","/show"})
    public String showPage(Model model, HttpServletRequest request){
        model.addAttribute("msg","This is Thymeleaf Html...");
        model.addAttribute("currentDate",new Date());
        model.addAttribute("sex","男");
        model.addAttribute("id","1");
        List<User> list = new ArrayList<>();
        list.add(new User("1","admin1",23));
        list.add(new User("2","admin2",13));
        list.add(new User("3","admin3",53));
        list.add(new User("4","admin4",35));
        model.addAttribute("users",list);


        Map<String , User> map = new HashMap<>();
        map.put("user1",new User("1","admin1",23));
        map.put("user2",new User("2","admin2",13));
        map.put("user3",new User("3","admin3",53));
        map.put("user4",new User("4","admin4",35));
        model.addAttribute("userMap",map);


        request.setAttribute("req","HttpServletRequest");
        request.getSession().setAttribute("ses","HttpSession");
        request.getServletContext().setAttribute("app","Application");

        model.addAttribute("id","666");
        model.addAttribute("name","MrRan");

        return "index";
    }


    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.addObject("msg","欢迎登录😂");
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping("/getParam")
    public ModelAndView login(String id, String name,ModelAndView modelAndView){
        System.out.println("ID:" + id + "---Name:" + name);
        modelAndView.setViewName("forward:/show");
        return modelAndView;
    }


    @GetMapping("/getParam2/{id}/{name}")
    public ModelAndView login2(@PathVariable String id,@PathVariable String name, ModelAndView modelAndView){
        System.out.println("ID:" + id +"---Name:" + name);
        modelAndView.setViewName("forward:/show");
        return modelAndView;
    }

    @GetMapping("/getParam4/{id}")
    public ModelAndView login4(@PathVariable String id, ModelAndView modelAndView){
        System.out.println("ID:" + id );
        modelAndView.setViewName("forward:/show");
        return modelAndView;
    }


    @GetMapping("/getParam3/{id}")
    public ModelAndView login3(@PathVariable String id, String name, ModelAndView modelAndView){
        System.out.println("ID:" + id +"---Name:" + name);
        modelAndView.setViewName("forward:/show");
        return modelAndView;
    }
}
