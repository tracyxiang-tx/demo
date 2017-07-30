package com.tracy.spring.basic.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tracy.spring.basic.aop.AspectBiz;
import com.tracy.spring.basic.aop.Fit;

public class TestAOP {

	private AspectBiz aspectBiz;
	private Fit fit;


	@Before
	public void before() {
		// 使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-aop-applicationContext.xml");
		aspectBiz = (AspectBiz) ac.getBean("aspectBiz");
		
		fit = (Fit) ac.getBean("aspectBiz");
	}

	
	//@Test
	public void testBiz() {

		aspectBiz.biz();
	}
	
	//@Test
	public void testInit() {

		aspectBiz.init("moocService",3);
	}
	
	@Test
	public void testFit() {

		fit.filter();
	}
	

}
