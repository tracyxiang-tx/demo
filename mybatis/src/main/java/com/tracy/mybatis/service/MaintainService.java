package com.tracy.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import com.tracy.mybatis.dao.MessageDao;

public class MaintainService {

	public void deleteOne(String id){
		MessageDao messageDao = new MessageDao();
		if(id != null && !"".equals(id.trim())) {
			messageDao.deleteOne(Integer.valueOf(id));
			
		}
	}
	public void deleteBatch(String[] ids){
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		
		for(String id: ids){
			idList.add(Integer.valueOf(id));
		}
		
		messageDao.deleteBatch(idList);
			
	}
}
