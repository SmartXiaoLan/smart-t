package cn.smart.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

//        System.out.println(authenticationToken.getPrincipal());

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiro", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("select password from users where username = ?");
            preparedStatement.setObject(1,authenticationToken.getPrincipal());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                //比较
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),
                        resultSet.getString("password"),"userRealm");
                return info;


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = principalCollection.getPrimaryPrincipal().toString();

        //获取username，然后去数据库查询这个用户对应的角色，在根据角色查询出指定角色下对应的菜单
        //返回给指定角色下的所有菜单--List集合
        System.out.println("username:"+username);

        //模拟数据库查询的菜单
        List<String> list = new ArrayList<>();
        list.add("updateUser");
        list.add("addUser");
        list.add("deleteUser");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        for (String ls : list){
            simpleAuthorizationInfo.addStringPermission(ls);
        }


        return simpleAuthorizationInfo;

    }


}
