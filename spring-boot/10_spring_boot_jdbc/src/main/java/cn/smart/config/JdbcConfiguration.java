package cn.smart.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 第一种方法：数据源的JDBC配置
 */
@Configuration
/*@PropertySource("classpath:/jdbc.properties")//加载指定的Properties配置文件*/
//@EnableConfigurationProperties(JdbcProperties.class) //指定加载配置属性类
public class JdbcConfiguration {

    /*@Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String passWord;*/

//    @Autowired
//    private JdbcProperties jdbcProperties;

    /*public JdbcConfiguration(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }**/

    /**
     * 实例化Druid
     *
     */
    @Bean
    @ConfigurationProperties(prefix = "jdbc")  //该注解的第三种使用方法
    public DataSource getDatasource(){
        DruidDataSource source = new DruidDataSource();
        /*source.setPassword(this.passWord);
        source.setUsername(this.userName);
        source.setUrl(this.url);
        source.setDriverClassName(this.driverClassName);*/
        /*source.setPassword(this.jdbcProperties.getPassWord());
        source.setUsername(this.jdbcProperties.getUserName());
        source.setUrl(this.jdbcProperties.getUrl());
        source.setDriverClassName(this.jdbcProperties.getDriverClassName());***/
        return source;
    }

}
