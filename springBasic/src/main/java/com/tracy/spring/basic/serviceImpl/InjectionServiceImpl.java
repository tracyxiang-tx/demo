package com.tracy.spring.basic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracy.spring.basic.dao.InjectionDao;
import com.tracy.spring.basic.service.InjectionService;

@Service
public class InjectionServiceImpl implements InjectionService {
	
	//@Autowired
	private InjectionDao injectionDao;
	
	//设值注入
	//@Autowired
	public void setInjectionDao(InjectionDao injectionDao) {
		this.injectionDao = injectionDao;
	}
	
	//构造器注入
	@Autowired
	public InjectionServiceImpl(InjectionDao injectionDao) {
		this.injectionDao = injectionDao;
	}

	public void save(String arg) {
		System.out.println("service 接受参数" + arg);
		arg = arg + ":" + this.hashCode();
		injectionDao.save(arg);
	
	}

}
