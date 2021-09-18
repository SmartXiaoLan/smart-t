package com.smart.service.impl;

import com.smart.dao.UserDao;
import com.smart.pojo.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String userName) {
        return this.userDao.getUser(userName);
    }
}
