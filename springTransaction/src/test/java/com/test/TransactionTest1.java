package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.transaction.service.AccountService;

/**
 * Spring声明式事务管理的方式一:基于TransactionProxyFactoryBean的方式
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext1.xml")
public class TransactionTest1 {

	//注入代理类：因为代理类进行增强的操作 
	
	//测试业务层类
//	@Resource(name="accountService")
	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	 
	@Test
	public void test1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
