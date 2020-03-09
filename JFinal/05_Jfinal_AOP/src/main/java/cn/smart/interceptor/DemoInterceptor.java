package cn.smart.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import java.lang.reflect.Method;

public class DemoInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before method invoking");
        /*
        注意：必须调用 inv.invoke() 方法，才能将当前调用传递到后续的 Interceptor 与 Action。
        常见错误：目前为止仍有很多同学忘了调用 inv.invoke() 方法，造成 controller 中的 action 不会被执行。在此再次强调一次，一定要调用一次 inv.invoke()，除非是刻意不去调用剩下的拦截器与 action，这种情况仍然需要使用 inv.getController().render()/renderJson() 调用一下相关的 render() 方法为客户端响应数据。
         */
        //传递本次调用，调用剩下的拦截器与目标方法
        invocation.invoke();
        //获取Action调用的Controller对象(仅用于控制层拦截)
        Controller controller = invocation.getController();
        //获取Action调用的action key值(仅用于控制层拦截)
        String actionKey = invocation.getActionKey();
        //获取Action调用的controller key值(仅用于控制层拦截)
        String controllerKey = invocation.getControllerKey();

        //获取Action调用的视图路径(仅用于视图层控制器)
        String viewPath = invocation.getViewPath();

        //获取被拦截方法所属对象
        Object target = invocation.getTarget();

        //获取被拦截方法的Method对象
        Method method = invocation.getMethod();

        //获取被拦截方法的方法名
        String methodName = invocation.getMethodName();

        //获取被拦截方法的所有参数值
        Object[] args = invocation.getArgs();

        //获取被拦截方法指定序号的参数值
        Object arg = invocation.getArg(0);

        //获取被拦截方法的返回值
        Object returnValue = invocation.getReturnValue();

        //设置被拦截方法指定序号的参数值
        invocation.setArg(1,new Object());

        //设置被拦截方法的返回值
        invocation.setReturnValue(new Object());

        //判断是否为Action调用，即是否为控制层拦截。
        boolean actionInvocation = invocation.isActionInvocation();


        System.out.println("After method invoking");
    }
}
