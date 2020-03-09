package com.bjsxt.mapper;

import com.bjsxt.pojo.Users;

import java.util.List;

public interface UsersMapper {

    void insertUsers(Users users);

    List<Users> selectAll();

    void deleteUserById(Integer userid);

}
