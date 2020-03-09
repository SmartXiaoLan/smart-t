package cn.smart.sevice.impl;

import cn.smart.mapper.UserMapper;
import cn.smart.pojo.User;
import cn.smart.pojo.UserExample;
import cn.smart.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void addUser(User user) {
        this.userMapper.insert(user);
    }

    @Override
    public List<User> findUsers() {
        return this.userMapper.selectByExample(new UserExample());
    }

    @Override
    public User preUpdateUser(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void modifyUserById(User user) {
        this.userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional
    public void dropUserById(Integer id) {
        this.userMapper.deleteByPrimaryKey(id);
    }
}
