package com.bjsxt.dubbo.service.impl;

import com.bjsxt.dubbo.service.SearchUserDubboService;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserDubboServiceImpl implements SearchUserDubboService {

    @Autowired
    private UsersMapper usersMapper ;

    @Override
    public List<Users> queryUsersAll() {
        return this.usersMapper.selectAll();
    }
}
