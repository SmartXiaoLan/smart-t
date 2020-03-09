package com.bjsxt.service.impl;

import com.bjsxt.service.DubboService;

/**
 *
 * @author Smart-T
 *
 * 服务接口实现类
 */
public class DubboServiceImpl implements DubboService {
    @Override
    public String showMsg(String str) {

        return "Hello Dubbo " + str;
    }
}
