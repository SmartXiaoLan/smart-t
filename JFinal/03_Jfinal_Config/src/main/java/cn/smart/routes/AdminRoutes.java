package cn.smart.routes;

import cn.smart.controller.AdminController;
import cn.smart.controller.UserController;
import cn.smart.interceptor.AdminInterceptor;
import com.jfinal.config.Routes;

/**
 * 后端路由
 */
public class AdminRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/view/admin");
        /**
         * Routes 级别的拦截器，该拦截器将拦截 AdminRoutes 中添加的所有 Controller，
         * 相当于业务层的inject拦截器，会在class拦截器之前被调用。
         * 这种用法可以避免在后台管理这样的模块中的所有class上使用@Before(AdminInterceptor.class)，减少代码冗余。
         */
        addInterceptor(new AdminInterceptor());
        add("/admin", AdminController.class);
        add("/admin/user", UserController.class);
    }
}
