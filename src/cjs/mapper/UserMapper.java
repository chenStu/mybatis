package cjs.mapper;

import cjs.entity.User;

public interface UserMapper {
	
	public User findUserById(int id) throws Exception;
	public void insertUser(User user) throws Exception;
}
