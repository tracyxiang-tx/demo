package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.transaction.service.AccountService;

/**
 * Spring编程式事务管理方法
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransactionTest {

	//测试业务层类
	@Resource(name="accountService")
	private AccountService accountService;
	 
	@Test
	public void test1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
