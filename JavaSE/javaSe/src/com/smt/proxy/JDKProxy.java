package com.smt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理对象
public class JDKProxy implements InvocationHandler {

    private Object obj;

    public JDKProxy(Object obj) {
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知...");
        //调用目标方法
        method.invoke(this.obj,args);
        System.out.println("方法执行结束后置通知...");
        return null;
    }
}

//JDK代理接口
interface DemoProxyInterface{
    void showMsg(String massage);
}

//JDK代理接口实现类
class DemoProxyClass implements DemoProxyInterface{

    @Override
    public void showMsg(String massage) {
        System.out.println("执行方法时显示的消息:"+massage);
    }
}

//测试类
class ProxyTest{

    public static void main(String[] args) {
        DemoProxyInterface demoProxyInterface = (DemoProxyInterface) Proxy.newProxyInstance(DemoProxyClass.class.getClassLoader(), DemoProxyClass.class.getInterfaces()
                , new JDKProxy(new DemoProxyClass()));
        demoProxyInterface.showMsg("代理成功中的自定义Masage...");
        System.out.println(demoProxyInterface.getClass());
    }

}