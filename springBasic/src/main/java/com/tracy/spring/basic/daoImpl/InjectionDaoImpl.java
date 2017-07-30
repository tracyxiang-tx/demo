package com.tracy.spring.basic.daoImpl;


import org.springframework.stereotype.Repository;

import com.tracy.spring.basic.dao.InjectionDao;

@Repository
public class InjectionDaoImpl implements InjectionDao {

	public void save(String arg) {
		System.out.println("save in database" + arg);
		
	}

}
