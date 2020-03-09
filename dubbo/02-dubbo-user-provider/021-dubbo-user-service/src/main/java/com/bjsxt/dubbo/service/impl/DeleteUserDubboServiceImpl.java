package com.bjsxt.dubbo.service.impl;

import com.bjsxt.dubbo.service.DeleteUserDubboService;
import com.bjsxt.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserDubboServiceImpl implements DeleteUserDubboService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void deleteUserById(Integer userid) {
        this.usersMapper.deleteUserById(userid);
    }
}
