package cn.smart.pojo;

import com.jfinal.plugin.activerecord.Model;

import java.io.Serializable;

public class User extends Model<User>  {

    private String userName;
    private Integer age;
    private Integer gender;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
