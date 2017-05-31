package com.tracy.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracy.test.dao.BlogMapper;
import com.tracy.test.entity.Blog;
import com.tracy.test.service.BlogServiceI;


/**
 * 
 * 使用@Service注解将blogServiceImpl类标注为一个service service的id是blogService
 */

@Service("blogService")
public class BlogServiceImpl implements BlogServiceI {

	/**
	 * 使用@Autowired注解标注blogMapper变量， 当需要使用blogMapper时，Spring就会自动注入blogMapper
	 */
	@Autowired
	private BlogMapper blogMapper;// 注入dao

	public void addBlog(Blog blog) {
		blogMapper.insert(blog);
	}

	public Blog getBlogById(Integer blogId) {
		return blogMapper.selectByPrimaryKey(blogId);
	}

	public List<Blog> getAllBlog() {
		return blogMapper.getAllBlog();
	}
	
	public void deleteByPrimaryKey(Integer blogId) {
		blogMapper.deleteByPrimaryKey(blogId);
	}
	
	public Blog selectByPrimaryKey(Integer blogId) {
		return blogMapper.selectByPrimaryKey(blogId);
	}
	
	public int updateByPrimaryKey(Blog blog) {
		return blogMapper.updateByPrimaryKey(blog);
	}

	

	

}
