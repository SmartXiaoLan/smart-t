package cn.smart.service;

import cn.smart.pojo.Users;

import java.util.List;

public interface UserService {
    void insertUser(Users user);

    List<Users> selectUserAll();
}
