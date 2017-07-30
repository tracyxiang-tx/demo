package com.tracy.spring.basic.aop.aspectj;

import org.springframework.stereotype.Service;

@Service
public class LogicBiz {
	
	
	
	@SelfMethod("LogicBiz save with SelfMethod.")
	public String save(String arg) {
		
		System.out.println("LogicBiz save : " + arg);
		//throw new RuntimeException("save failed!");
		return "save success!";
	}
}
