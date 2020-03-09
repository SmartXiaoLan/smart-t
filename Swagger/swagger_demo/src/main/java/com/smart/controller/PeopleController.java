package com.smart.controller;

import com.smart.config.NotIncludeSwagger;
import com.smart.vo.People;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/people")
//类级别的Api注解，可以控制类的名称和描述
//多个会生成一个副本，一般一个
//@Api(tags = {"获取人的接口信息","----------->"})
@Api(tags = {"获取人的接口信息"} , description = "描述")
public class PeopleController {

//    @RequestMapping("/getPeople")
//    @NotIncludeSwagger
    //方法级别的接口描述value-->描述；notes-->大段描述
    /*@ApiOperation(value = "获取人JSON" , notes = "通过人的编号和姓名查询对应信息")
    @PostMapping("/getPeople")*/
    /*
        方法参数前面的描述，用于参数进行描述或说明是否为必填项等说明
            name:参数名称
            value:参数描述
            required:是否必须
     */
    /*public People getPeople(Long id ,@ApiParam(name = "name" , value = "用户姓名",required = true) String name){
        People people = new People();
        people.setId(id);
        people.setName(name);
        people.setAddress("成都");
        return people;
    }*/
    @ApiOperation(value = "获取人JSON" , notes = "通过人的编号和姓名查询对应信息")
    @PostMapping("/getPeople")
    /*
        方法参数前面的描述，用于参数进行描述或说明是否为必填项等说明
            name:参数名称
            value:参数描述
            required:是否必须
     */
    public People getPeople(People people){
        return people;
    }


    //该注解用于忽略方法、类、参数
    @ApiIgnore
    @PostMapping("/getPeople2")
    public People getPeople(Integer id , @ApiIgnore String name){
        return null;
    }


    @PostMapping("/getPeople3")
    //作用在方法上的参数描述
//    @ApiImplicitParam(name = "id" , value = "123" , required = true , dataType = "double" , paramType = "body")
//    @ApiImplicitParam(name = "name" , value = "姓名" , required = false)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id" , value = "123" , required = true , dataType = "double" , paramType = "body"),
            @ApiImplicitParam(name = "name" , value = "姓名" , required = true , dataType = "string" , paramType = "query")
    })
    public People getPeople(double id ,  String name){
        return null;
    }

}
