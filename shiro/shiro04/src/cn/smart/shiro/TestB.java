package cn.smart.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestB {

    public static void main(String[] args) {
        /*Realm*/
        //[1]解析Shiro.ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc2.ini");

        //[2]通过SecurityManager工厂获得SecurityManager实例
        SecurityManager manager = factory.getInstance();

        //[3]把SecurityManager对象设置到运行环境中
        SecurityUtils.setSecurityManager(manager);

        //[4]通过SecurityUtils获得主体对象subject
        Subject subject = SecurityUtils.getSubject();

        //[5]书写自己输入的账号和密码-->相当于用户自己输入的账号和密码
        UsernamePasswordToken token = new UsernamePasswordToken("root","123");

        try {
            //[6]进行身份的验证
            subject.login(token);

            //[7]通过方法判断是否登录成功

            if (subject.isAuthenticated()){
                System.out.println("登录成功...");

                //授权的校验
                System.out.println("是否存在该菜单："+subject.isPermitted("updateUser12"));
            }
        } catch (AuthenticationException e) {
            System.out.println("登录失败");
        }

    }
}
