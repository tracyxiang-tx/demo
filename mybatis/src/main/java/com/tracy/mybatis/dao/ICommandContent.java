package com.tracy.mybatis.dao;

import java.util.List;

import com.tracy.mybatis.bean.CommandContent;

/**
 * 与CommandContent配置文件相对应的接口
 */
public interface ICommandContent {
	/**
	 * 单条新增
	 */
	public void insertOne(CommandContent content);
	
	/**
	 * 批量新增
	 */
	public void insertBatch(List<CommandContent> content);
}
