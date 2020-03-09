package cn.smart.routes;

import cn.smart.controller.IndexAdminController;
import cn.smart.controller.ProjectAdminController;
import cn.smart.controller.ShareAdminController;
import cn.smart.interceptor.AdminAuthInterceptor;
import com.jfinal.config.Routes;

//Routes级别拦截器是指在Routes中添加的拦截器

/**
 * Routes 拦截器在功能上通过一行代码，同时为多个 Controller 配置好相同的拦截器，减少了代码冗余。Routes 级别拦截器将在 Class 级别拦截器之前被调用。
 */
public class AdminRoutes extends Routes {
    @Override
    public void config() {
        //此处配置Routes级别拦截器，可配置多个
        addInterceptor(new AdminAuthInterceptor());

        add("/admin", IndexAdminController.class, "/index");
        add("/admin/project", ProjectAdminController.class, "/project");
        add("/admin/share", ShareAdminController.class, "/share");

    }
}
