package com.tracy.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracy.test.dao.UserMapper;
import com.tracy.test.entity.User;
import com.tracy.test.service.UserServiceI;

/**
 * 
 * 使用@Service注解将UserServiceImpl类标注为一个service service的id是userService
 */

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	/**
	 * 使用@Autowired注解标注userMapper变量， 当需要使用UserMapper时，Spring就会自动注入UserMapper
	 */
	@Autowired
	private UserMapper userMapper;// 注入dao

	public void addUser(User user) {
		userMapper.insert(user);
	}

	public User getUserById(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}
	
	public void deleteByPrimaryKey(Integer userId) {
		userMapper.deleteByPrimaryKey(userId);
	}
	
	public User selectByPrimaryKey(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	
	public int updateByPrimaryKey(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

}
