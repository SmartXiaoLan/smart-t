package com.bjsxt.service;

import com.bjsxt.pojo.Users;

import java.util.List;

public interface UserService {

    void addUser(Users users);

    List<Users> findUserAll();

    void dropUserById(Integer userid);

}
