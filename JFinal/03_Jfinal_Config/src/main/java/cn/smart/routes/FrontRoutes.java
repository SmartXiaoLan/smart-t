package cn.smart.routes;

import cn.smart.controller.BlogController;
import cn.smart.controller.IndexController;
import com.jfinal.config.Routes;

/**
 * 前端路由
 */
public class FrontRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/view/front");
        add("/", IndexController.class);
        add("/blog", BlogController.class);
    }
}
