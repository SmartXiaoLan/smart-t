package cn.smart.controller;

import cn.smart.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/tes")
public class PostController {

    @RequestMapping(value = "/httpPost",method = RequestMethod.POST)
    @ResponseBody
    public Object postTest(){
        Map<String,String> map = new HashMap<>();
        map.put("msg","The Server Received>>>");
        return map;
    }


    //响应乱码解决
    @RequestMapping(value = "/httpPost/param",method = RequestMethod.POST ,
            produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public Object postParamTest(String name , String pwd){
        Map<String,String> map = new HashMap<>();
        map.put("msg","The Server Received>>>");
        map.put("name",name);
        map.put("pwd", pwd);
        return map;
    }

    //响应乱码解决
    @RequestMapping(value = "/httpPost/param/json",method = RequestMethod.POST)
    //接受Json参数
    @ResponseBody
    public Object postJsonParamTest(@RequestBody User user){
        Map<String,String> map = new HashMap<>();
        map.put("msg","The Server Received>>>");
        map.put("name",user.getName());
        map.put("pwd", user.getPwd());
        return map;
    }

}
