package cn.smart.service;

import cn.smart.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> findUserAll();

    User findUserById(Integer id);

    void modifyUser(User user);

    void deleteUser(Integer id);
}
