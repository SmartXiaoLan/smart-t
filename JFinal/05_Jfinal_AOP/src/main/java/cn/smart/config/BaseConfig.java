package cn.smart.config;

import cn.smart.interceptor.GlobalActionInterceptor;
import cn.smart.interceptor.GlobalServiceInterceptor;
import com.jfinal.config.*;
import com.jfinal.template.Engine;

public class BaseConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        //开启时jfinal web项目组件Controller、Interceptor、Validator的注入
        constants.setInjectDependency(true);

        //开启对超类的注解。不开启时可以在超类中通过Aop.get()进行注入
        constants.setInjectSuperClass(true);

        //配置CGLIB动态代理
        //切换CGLIB代理模式
        constants.setToCglibProxyFactory(); //4.6版本配置方式

        /*
            如果是在 "非 web 环境" 下使用，配置方法如下：
            // 4.6 之前的版本的配置方式: ProxyManager.me().setProxyFactory(new CglibProxyFactory());
            ProxyManager.me().setToCglibProxyFactory();
         */
    }

    @Override
    public void configRoute(Routes routes) {

    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    /**
     * 除了 Class 与 Method 级别的拦截器以外，JFinal 还支持全局拦截器以及 Routes 拦截器，
     * 全局拦截器分为控制层全局拦截器与业务层全局拦截器，前者拦截控制 层所有 Action 方法，后者拦截业务层所有方法。
     * @param interceptors
     */

    /*
        拦截器各级别执行的次序依次为：Global、Routes、Class、Method，如果同级中有多个拦截器，那么同级中的执行次序是：配置在前面的先执行
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {
        //添加控制层全局拦截器
        interceptors.addGlobalActionInterceptor(new GlobalActionInterceptor());

        //添加业务层全局拦截器
        interceptors.addGlobalServiceInterceptor(new GlobalServiceInterceptor());

        //为兼容老版本保留方法，功能与addGlobalActionInterceptor完全一样
        interceptors.add(new GlobalActionInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
