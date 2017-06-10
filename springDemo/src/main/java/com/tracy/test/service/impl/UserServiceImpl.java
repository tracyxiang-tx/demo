package com.tracy.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;  
import org.springframework.cache.annotation.Cacheable;

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
	
	@CacheEvict(value = { "addUser"}, allEntries = true)  
	public void addUser(User user) {
		userMapper.insert(user);
	}
	
	@Cacheable("getUserById")  
	public User getUserById(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	
	@Cacheable("getAllUser")
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}
	@CacheEvict(value = { "getAllUser", "getUserById" }, allEntries = true) 
	public void deleteByPrimaryKey(Integer userId) {
		userMapper.deleteByPrimaryKey(userId);
	}
	
	public User selectByPrimaryKey(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	
	@CacheEvict(value = { "getAllUser", "getUserById" }, allEntries = true) 
	public int updateByPrimaryKey(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

}
