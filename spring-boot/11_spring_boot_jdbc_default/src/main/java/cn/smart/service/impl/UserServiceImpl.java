package cn.smart.service.impl;

import cn.smart.dao.UserDao;
import cn.smart.pojo.User;
import cn.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户管理业务层
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.insertUser(user);
    }

    @Override
    public List<User> findUserAll() {
        return this.userDao.selectUserAll();
    }

    /**
     * 与更新用户信息
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        return this.userDao.selectUserById(id);
    }

    /**
     * 修改用户信息
     * @param user
     */
    @Override
    @Transactional
    public void modifyUser(User user) {
        this.userDao.updateUser(user);
    }

    /**
     * 根据ID做用户删除
     * @param id
     */
    @Override
    @Transactional
    public void deleteUser(Integer id) {
        this.userDao.dropUser(id);
    }
}
