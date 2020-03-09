package cn.smart.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 错误的写法
 */
public class MyInterceptor implements Interceptor {

    private Integer value = 123;

    //其中的 value 属性将会被多线程访问到，从而引发线程安全问题。
    @Override
    public void intercept(Invocation invocation) {
    }
}
