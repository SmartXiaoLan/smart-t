package cn.smart.config;

import cn.smart.controller.IndexController;
import cn.smart.controller.ProjectController;
import cn.smart.render.factory.MyRenderFactory;
import cn.smart.route.FrontRoutes;
import com.jfinal.config.*;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class BaseConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        //render(String view) 将根据 configConstant(Constants me) 中配置的 me.setViewType(ViewType) 方法选择一种模板引进渲染模板文件
        constants.setViewType(ViewType.JFINAL_TEMPLATE);
        constants.setDevMode(true);
        // 配置生效
        constants.setRenderFactory(new MyRenderFactory());
    }

    /**
     * 自 jfinal 3.6 开始，控制器超类中的所有方法默认不会被映射为 action。
     * （也就是自 jfinal 3.6 版本开始上例中 BaseController 中的 @NotAction 默认已经不需要了，
     * 因为 BaseController 是你最终控制器 XxxController 的超类）
     * @param routes
     */
    @Override
    public void configRoute(Routes routes) {
        //该配置对所有有效
        routes.setMappingSuperClass(true);
        routes.add(new FrontRoutes());

        //baseViewPath 为 "/_view"，该 Routes 对象之下映射的所有 Controller 都将取这个值
        routes.setBaseViewPath("/pages");

        //basePath 为第三个参数"/index"
        routes.add("/", IndexController.class,"/index");

        // 第三个参数省略时， basePath 取第一个参数的值 : "/project"
        routes.add("/project", ProjectController.class);

        //其中的 me.setBaseViewPath(...) 指定的值即为 baseViewPath，其中 me.add(...) 第三个参数即为 viewPath，当第三个参数省略时默认取第一个参数的值。

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
