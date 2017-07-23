package com.spring.transaction.serviceImpl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.dao.AccountDao;
import com.spring.transaction.service.AccountService;

/**
 * 基于注解的方式
 * @Transactional注解中的属性
 * propagation : 事务的传播行为
 * isolation   : 事务的隔离级别
 * readOnly    : 只读(不可以进行修改，插入和删除操作)
 * rollbackFor  : 发生哪些异常回滚事务
 * noRollbackFor  : 发生哪些异常事务不回滚
 *
 */
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT,readOnly=false)
public class AccountServiceImpl3 implements AccountService {
	// 注入转账的DAO的类
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String out, String in, Double money) {

		accountDao.outMoney(out, money);
		int i = 1 / 0;
		accountDao.inMoney(in, money);

	}

}
