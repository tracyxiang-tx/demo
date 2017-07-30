package com.tracy.spring.basic.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tracy.spring.basic.aop.AspectBiz;
import com.tracy.spring.basic.aop.Fit;
import com.tracy.spring.basic.aop.api.BizLogic;
import com.tracy.spring.basic.aop.aspectj.LogicBiz;

public class TestAOPAspectJ {

	private LogicBiz logicBiz;


	@Before
	public void before() {
		// 使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-aop-aspectj.xml");
		logicBiz = (LogicBiz) ac.getBean("logicBiz");
		
	}

	
	@Test
	public void testAspect() {

		logicBiz.save("This is test!");
	}
	
	

}
