package com.bjsxt.service.impl;

import com.bjsxt.dubbo.service.AddUserDubboService;
import com.bjsxt.dubbo.service.DeleteUserDubboService;
import com.bjsxt.dubbo.service.SearchUserDubboService;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private AddUserDubboService addUserDubboService;

    @Autowired(required = false)
    private SearchUserDubboService searchUserDubboService;

    @Autowired(required = false)
    private DeleteUserDubboService deleteUserDubboService;

    @Override
    public void addUser(Users users) {
        this.addUserDubboService.addUser(users);
    }

    @Override
    public List<Users> findUserAll() {
        return this.searchUserDubboService.queryUsersAll();
    }

    @Override
    public void dropUserById(Integer userid) {
        this.deleteUserDubboService.deleteUserById(userid);
    }
}
