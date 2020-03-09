package cn.smart.other;

import cn.smart.service.Service;
import cn.smart.service.impl.MyService;
import com.jfinal.aop.AopManager;
import com.jfinal.aop.Inject;

public class InjectOther {
    //@Inject 注解还支持指定注入的实现类
    @Inject(MyService.class)
    Service service;
}
