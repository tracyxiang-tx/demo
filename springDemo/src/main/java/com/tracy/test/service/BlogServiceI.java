package com.tracy.test.service;

import java.util.List;

import com.tracy.test.entity.Blog;

public interface BlogServiceI {

	/**
	 * 添加用户
	 * 
	 * @param Blog
	 */

	void addBlog(Blog Blog);

	/**
	 * 根据用户id获取用户
	 * 
	 * @param BlogId
	 */
	Blog getBlogById(Integer BlogId);

	/**
	 * 获取所有用户信息
	 * 
	 * @return List<Blog>
	 */
	List<Blog> getAllBlog();
	
	void deleteByPrimaryKey(Integer BlogId);
	
	Blog selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKey(Blog record);
	
}
