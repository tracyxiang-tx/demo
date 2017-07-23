package com.spring.transaction.serviceImpl;

import com.spring.transaction.dao.AccountDao;
import com.spring.transaction.service.AccountService;

public class AccountServiceImpl1 implements AccountService {
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
