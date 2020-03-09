package com.bjsxt.service.impl;

import com.bjsxt.service.DubboService;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DubboService dubboService;


    @Override
    public void test(String str) {
        //调用provider下的服务
        System.out.println(this.dubboService);
        String var = this.dubboService.showMsg(str);
        System.out.println(var);
    }
}
