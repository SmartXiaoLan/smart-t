package com.smart.controller;

import com.smart.config.NotIncludeSwagger;
import com.smart.vo.People;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class People2Controller {

//    @RequestMapping("/getPeople")
//    @NotIncludeSwagger
    @PostMapping("/getPeople")
    public People getPeople(Long id , String name){
        People people = new People();
        people.setId(id);
        people.setName(name);
        people.setAddress("成都");
        return people;
    }

}
