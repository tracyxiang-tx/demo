package com.tracy.mybatis.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tracy.mybatis.bean.Command;
import com.tracy.mybatis.db.DBAccess;

public class CommandDao {
	
	public List<Command> queryCommandList(String name, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			
			//通过sqlSession执行SQL语句
			commandList = sqlSession.selectList("Command.queryCommandList", command);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
			
		}
		
		return commandList;
		
	}
	
}
