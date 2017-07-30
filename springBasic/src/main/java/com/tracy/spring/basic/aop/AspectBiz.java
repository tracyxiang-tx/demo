package com.tracy.spring.basic.aop;

public class AspectBiz {

	public void biz(){
		System.out.println("AspectBiz biz method!");
		//throw new RuntimeException();
	}
	
	public void init(String bizName, int times){
		System.out.println("AspectBiz init : "+ bizName + "   " + times);
		//throw new RuntimeException();
	}
}
