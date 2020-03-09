package cn.smart.interceptor;

import cn.smart.service.AccountService;
import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 *  @Inject 还可以用于拦截器的属性注入
 */
public class MyInterceptor2 implements Interceptor {

    @Inject
    AccountService service;

    @Override
    public void intercept(Invocation invocation) {
        service.justDoIt();     // 调用被注入对象的方法
        invocation.invoke();
    }
}
