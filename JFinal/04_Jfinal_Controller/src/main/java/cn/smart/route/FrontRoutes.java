package cn.smart.route;

import cn.smart.controller.ProjectController;
import cn.smart.controller.WeiXinController;
import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {
    @Override
    public void config() {
        //// 这里配置只对 FrontRoutes 下的路由有效，建议这样配置以提升性能
        setMappingSuperClass(true);
        add("/weixin", WeiXinController.class);
        add("/pro", ProjectController.class);
    }
}
