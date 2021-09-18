package com.smt.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ref {
    public <T> List<T> queryEmployees(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
                    ps = conn.prepareStatement(sql);
                    if (args != null && args.length > 0)
                        for (int i = 0; i < args.length; i++)
                            ps.setObject(i + 1, args[i]);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        T t = clazz.newInstance();
                        Field[] fields = clazz.getDeclaredFields();
                        for (Field field : fields) {
                            String name = field.getName();
                            String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                            Method method = clazz.getMethod(methodName, field.getType());
                            System.out.println(methodName);
                            method.invoke(t, rs.getObject(name));
                        }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }
}