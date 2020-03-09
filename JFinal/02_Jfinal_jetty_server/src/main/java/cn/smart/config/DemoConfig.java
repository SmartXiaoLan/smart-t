package cn.smart.config;

import cn.smart.controller.HelloController;
import com.jfinal.config.*;
import com.jfinal.template.Engine;

/**
 * @author Smart-T
 *
 * 该类时Jfinal启动的配置类需要继承JFinalConfig类才可以自定义配置
 *
 */
public class DemoConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        //设置是否为开发模式？热加载支持?
        constants.setDevMode(true);
    }

    //URl路由配置
    @Override
    public void configRoute(Routes routes) {
        //1:访问的路径。2.对应的视图Controller
        routes.add("/hello", HelloController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
