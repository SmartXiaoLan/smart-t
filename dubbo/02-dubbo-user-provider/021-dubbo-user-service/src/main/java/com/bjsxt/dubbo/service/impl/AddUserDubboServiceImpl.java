package com.bjsxt.dubbo.service.impl;

import com.bjsxt.dubbo.service.AddUserDubboService;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserDubboServiceImpl implements AddUserDubboService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUsers(users);

    }
}
