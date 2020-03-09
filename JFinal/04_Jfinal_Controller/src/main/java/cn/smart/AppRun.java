package cn.smart;

import cn.smart.config.BaseConfig;
import com.jfinal.server.undertow.UndertowServer;

public class AppRun {

    public static void main(String[] args) {
        UndertowServer.start(BaseConfig.class);
    }

}
