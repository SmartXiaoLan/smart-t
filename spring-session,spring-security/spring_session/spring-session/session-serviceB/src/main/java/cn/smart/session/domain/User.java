package cn.smart.session.domain;

import java.io.Serializable;

//操作对象时必须实现序列化接口
public class User implements Serializable {

    private String userName;

    private String password;

    //带有关联关系的序列化，该对象也需要实现序列化

    private Roles roles;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
