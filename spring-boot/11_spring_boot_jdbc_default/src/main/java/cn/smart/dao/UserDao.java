package cn.smart.dao;

import cn.smart.pojo.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);

    List<User> selectUserAll();

    User selectUserById(Integer id);

    void updateUser(User user);

    void dropUser(Integer id);
}
