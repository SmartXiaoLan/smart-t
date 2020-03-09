package cn.smart.dao.impl;

import cn.smart.dao.UserDao;
import cn.smart.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate =  jdbcTemplate;}

    @Override
    public void insertUser(User user) {
        String sql = "insert into user(username,usersex) values(?,?)";
        jdbcTemplate.update(sql,user.getUsername(),user.getUsersex());
    }

    @Override
    public List<User> selectUserAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            /**
             * 结果集的映射
             * @param resultSet
             * @param i
             * @return
             * @throws SQLException
             */
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setUsersex(resultSet.getString("usersex"));
                return user;
            }
        });
    }

    /**
     * 根据用户ID查询用户
     * @param id
     * @return
     */
    @Override
    public User selectUserById(Integer id) {
        User user = new User();
        String sql = "select * from user where userid=?";
        Object [] arr = new Object[]{id};
        this.jdbcTemplate.query(sql, arr, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserid(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setUsersex(resultSet.getString("usersex"));
            }
        });
        return user;
    }

    /**
     * 修改用户信息
     * @param user
     */
    @Override
    public void updateUser(User user) {
        String sql = "update user set username = ? , usersex = ? where userid = ?";
        this.jdbcTemplate.update(sql,user.getUsername(),user.getUsersex(),user.getUserid());
    }

    /**
     * 根据用户ID删除用户
     * @param id
     */
    @Override
    public void dropUser(Integer id) {
        String sql = "delete from user where userid = ?";
        this.jdbcTemplate.update(sql,id);
    }
}
