package cn.smart.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 第二种方法JDBC配置信息属性类
 */
//@ConfigurationProperties(prefix = "jdbc") //是Spring Boot的专有注解。不可以去读取其他配置文件，只能读取SpringBoot的application配置文件。
public class JdbcProperties {

    private String driverClassName;
    private String url;
    private String userName;
    private String passWord;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
