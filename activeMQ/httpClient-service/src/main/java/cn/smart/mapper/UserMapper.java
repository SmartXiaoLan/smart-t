package cn.smart.mapper;

import cn.smart.pojo.Users;

import java.util.List;

public interface UserMapper {

	public void insertUser(Users user);
	
	public List<Users> selectUserAll();
	
	Users findUserById(int userid);
	
	void updateUser(Users users);
}
