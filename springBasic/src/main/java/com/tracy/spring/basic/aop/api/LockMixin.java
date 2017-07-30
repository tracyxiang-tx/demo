package com.tracy.spring.basic.aop.api;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class LockMixin extends DelegatingIntroductionInterceptor implements
		Lockable {

	private boolean locked;

	public void lock() {
		this.locked = true;

	}

	public void unlock() {
		this.locked = false;

	}

	public boolean locked() {
		// TODO Auto-generated method stub
		return this.locked;
	}
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if(locked() && invocation.getMethod().getName().indexOf("set") == 0) {
			throw new RuntimeException();
		}
		return super.invoke(invocation);
	}
	

}
