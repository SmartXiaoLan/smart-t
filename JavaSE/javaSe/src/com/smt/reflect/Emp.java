package com.smt.reflect;

import java.util.List;
import java.util.Map;

public class Emp {

    private int userid;

    private String username;

    private String usersex;

    public Emp() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    @Override
    public String toString() {
        return "Emp{" + 
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        /*Emp emp = Emp.class.newInstance();
        Field[] declaredFields = Emp.class.getDeclaredFields();
        for(Field file : declaredFields){
            Class<?> type = file.getType();
            System.out.println(type.getName());
        }*/
        Ref ref = new Ref();
        String sql = "select * from user limit ?,?";
        List<Emp> emps = ref.queryEmployees(Emp.class, sql, 1,1);
        System.out.println(emps);
    }

}
