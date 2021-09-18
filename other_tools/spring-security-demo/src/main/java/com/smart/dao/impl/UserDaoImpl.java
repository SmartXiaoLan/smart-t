package com.smart.dao.impl;

import com.smart.dao.UserDao;
import com.smart.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public User getUser(String userName) {
        User user = new User();
        Object[] arr = new Object[]{userName};
        return this.jdbcTemplate.queryForObject("select * from smart_user where user_name=?", arr,
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        user.setUserId(rs.getInt("user_id"));
                        user.setUserName(rs.getString("user_name"));
                        user.setUserCustomName((rs.getString("user_custom_name")));
                        user.setUserPassword(rs.getString("user_password"));
                        user.setUserLocked(rs.getInt("user_locked"));
                        user.setUserRole((Integer) rs.getObject("user_role"));
                        return user;
                    }
                });
    }
}
