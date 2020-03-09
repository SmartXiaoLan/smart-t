package cn.smart.service.impl;

import cn.smart.mapper.UserMapper;
import cn.smart.pojo.Users;
import cn.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(Users user) {
        this.userMapper.insertUser(user);
    }

    @Override
    public List<Users> selectUserAll() {
        return this.userMapper.selectUserAll();
    }
}
