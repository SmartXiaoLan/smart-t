package cn.smart.web.controller;

import cn.smart.commons.JsonUtils;
import cn.smart.pojo.User;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //普通的
    /*@RequestMapping("/findUser")
    public Object findUser(){
        User user = new User(1,"admin",20);
        User user1 = new User(2,"zhangsan",30);
        User user2 = new User(3,"lisi",10);

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);

        return list;
    }*/

    /*//手动JsonP跨域
    @RequestMapping("/findUser")
    public String findUser(@RequestParam("callback") String data){
        User user = new User(1,"admin",20);
        User user1 = new User(2,"zhangsan",30);
        User user2 = new User(3,"lisi",10);

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);

        //手动方法
        String json = JsonUtils.objectToJson(list);

        //callback({id:1,name:....})
        return data+"("+json+")";
    }*/

    //SpringMVC自动JsonP跨域
    @RequestMapping("/findUser")
    public MappingJacksonValue findUser(@RequestParam("callback") String data){
        User user = new User(1,"admin",20);
        User user1 = new User(2,"zhangsan",30);
        User user2 = new User(3,"lisi",10);

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);

        //SpringMVCAPI
        MappingJacksonValue value = new MappingJacksonValue(list);

        value.setJsonpFunction(data);
        //callback({id:1,name:....})
        return value;
    }

}
