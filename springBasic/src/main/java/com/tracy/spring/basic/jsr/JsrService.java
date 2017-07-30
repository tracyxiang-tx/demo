package com.tracy.spring.basic.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

//@Service
@Named
public class JsrService {

	//@Resource
	//@Inject
	private JsrDao jsrDao;

	// @Resource
	@Inject
	public void setJsrDao(@Named("jstDao") JsrDao jsrDao) {
		this.jsrDao = jsrDao;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init method!");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy method!");
	}

	public void save() {
		jsrDao.save();
	}
}
