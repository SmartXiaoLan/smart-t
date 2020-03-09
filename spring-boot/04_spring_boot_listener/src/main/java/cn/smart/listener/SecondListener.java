package cn.smart.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 第二种实现
 */
public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener2 init....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
