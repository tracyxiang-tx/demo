package com.tracy.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.tracy.mybatis.bean.Message;

/**
 * 与message对应文件相对应的接口
 */
public interface IMessage {
	/**
	 * 根据查询条件查询消息列表
	 */
	/*public List<Message> queryMessageList(Message message);*/
	public List<Message> queryMessageList(Map<String,Object> parameter);

	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message message);

	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String, Object> parameter);

}
