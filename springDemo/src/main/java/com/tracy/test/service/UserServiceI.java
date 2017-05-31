package com.tracy.test.service;

import java.util.List;

import com.tracy.test.entity.User;

public interface UserServiceI {

	/**
	 * 添加用户
	 * 
	 * @param user
	 */

	void addUser(User user);

	/**
	 * 根据用户id获取用户
	 * 
	 * @param userId
	 */
	User getUserById(Integer userId);

	/**
	 * 获取所有用户信息
	 * 
	 * @return List<User>
	 */
	List<User> getAllUser();
	
	void deleteByPrimaryKey(Integer userId);
	
	User selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKey(User record);
}
