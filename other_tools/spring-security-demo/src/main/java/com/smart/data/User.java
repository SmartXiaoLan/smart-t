package com.smart.data;

import lombok.Data;

@Data
public class User {


    private String username;

    private Integer age;

    private Character gender;

    public User() {
    }

    public User(String username, Integer age, Character gender) {
        this.username = username;
        this.age = age;
        this.gender = gender;
    }


}
