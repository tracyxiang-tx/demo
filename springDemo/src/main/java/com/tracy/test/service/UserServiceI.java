package com.tracy.test.service;

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
}
