package cn.smart.service.impl;

import cn.smart.pojo.User;
import cn.smart.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void showUser(User user) {
        System.out.println(user);
    }
}
