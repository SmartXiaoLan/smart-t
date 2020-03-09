package cn.smart;

import cn.smart.config.DemoConfig;
import com.jfinal.server.undertow.UndertowServer;
import io.undertow.UndertowOptions;

/**
 * @author Smart-T
 *
 * 独立的启动类
 *
 */
public class ApplicationStart {
    public static void main(String[] args) {
        //jfinal基础启动入口
//        UndertowServer.start(DemoConfig.class,80,true);

        //Undertow自由配置方式
        /*UndertowServer.create(DemoConfig.class)
                .onStart(builder -> {
                    builder.setServerOption(UndertowOptions.参数名, 参数值);
                }).start();*/

        //添加过滤器(Filter)、WebSocket、Servlet、监听器(Listener)
        UndertowServer.create(DemoConfig.class)
                .configWeb(builder -> {
                    //Filter
                    builder.addFilter("filterName","FilterClass");
                    builder.addFilterUrlMapping("filterName","/*");
                    builder.addFilterInitParam("filterName","key","value");

                    // 配置Servlet
                    builder.addServlet("servletName","servletClass");
                    builder.addServletMapping("servletName", "*.do");
                    builder.addServletInitParam("servletName", "key", "value");

                    //监听器
                    builder.addListener("listenerClass");

                    // 配置 WebSocket，MyWebSocket 需使用 ServerEndpoint 注解
                    builder.addWebSocketEndpoint("com.abc.MyWebSocket");
                }).start();
    }
}
