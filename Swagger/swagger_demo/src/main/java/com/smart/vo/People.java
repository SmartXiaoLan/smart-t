package com.smart.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/*
    实体类上的Api注解

 */
@ApiModel(value = "人的实体类", description = "实体类，封装了客户的所有信息")
public class People implements Serializable {

    private String name;
    //
    @ApiModelProperty(value = "编号" , name = "id" , required = true ,example = "123")
    private Long id;
    @ApiModelProperty(hidden = true)
    private String address;

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
