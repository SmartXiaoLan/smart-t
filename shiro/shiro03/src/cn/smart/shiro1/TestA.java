package cn.smart.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.Arrays;

public class TestA {

    public static void main(String[] args) {
        /*Realm*/
        //[1]解析Shiro.ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //[2]通过SecurityManager工厂获得SecurityManager实例
        SecurityManager manager = factory.getInstance();

        //[3]把SecurityManager对象设置到运行环境中
        SecurityUtils.setSecurityManager(manager);

        //[4]通过SecurityUtils获得主体对象subject
        Subject subject = SecurityUtils.getSubject();

        //[5]书写自己输入的账号和密码-->相当于用户自己输入的账号和密码
        UsernamePasswordToken token = new UsernamePasswordToken("zs","123");

        try {
            //[6]进行身份的验证
            subject.login(token);

        } catch (AuthenticationException e) {
            System.out.println("登录失败");
        }

        //授权的查询

        //基于角色的授权
        boolean flag = subject.hasRole("role1");

//        System.out.println(flag);

        //判断是否具有多个角色
        boolean[] booleans = subject.hasRoles(Arrays.asList("role1", "role2","role"));

        /*for (boolean b :
                booleans) {
            System.out.println(b);
        }*/

        //可以使用checkRole判断指定用户是否具有对应角色
        //如果指定用户下没有指定的角色就会抛出异常UnauthorizedException
        /*subject.checkRole("role3");

        subject.checkRoles("role1","role2");*/

        //基于资源的授权
        boolean flag2 = subject.isPermitted("add");
        System.out.println(flag2);


        //判断是否具有多个资源
        boolean permittedAll = subject.isPermittedAll("add", "ii", "oo");

        //通过checkPermission进行判断指定用户下是否有指定的资源
        //如果没有就会抛出UnauthorizedException
        subject.checkPermission("uu");

        subject.checkPermissions("ii","o");


    }
}
