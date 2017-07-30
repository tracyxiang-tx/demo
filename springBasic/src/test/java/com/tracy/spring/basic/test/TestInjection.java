package com.tracy.spring.basic.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tracy.spring.basic.bean.Store;
import com.tracy.spring.basic.jsr.JsrService;
import com.tracy.spring.basic.multibean.BeanInvoker;
import com.tracy.spring.basic.service.InjectionService;

public class TestInjection {

	private InjectionService injectionService;

	private BeanInvoker invoker;
	
	private Store store;
	
	private JsrService jsrService;

	@Before
	public void before() {
		// 使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 从Spring容器中根据bean的id取出我们要使用的userService对象
		injectionService = (InjectionService) ac
				.getBean("injectionServiceImpl");
		invoker = (BeanInvoker) ac.getBean("beanInvoker");
		store = (Store) ac.getBean("store");
		jsrService = (JsrService) ac.getBean("jsrService");
	}

	// @Test
	public void testSetter() {
		injectionService.save("这是要保存的数据");

	}

	//@Test
	public void testMultiBean() {

		invoker.say();
	}

	//@Test
	public void testBean() {

		System.out.println(store.getClass().getName());
	}
	
	//@After
	public void after() {

		System.out.println("JUnit test after");
	}
	
	@Test
	public void testJsr() {

		jsrService.save();
	}
	

}
