package cn.smart.service;

import cn.smart.pojo.Users;

public interface UsersService {
    void addUser(Users users);

    Users queryUserById(Integer userid);

    void modifyUserById(Users users);
}
