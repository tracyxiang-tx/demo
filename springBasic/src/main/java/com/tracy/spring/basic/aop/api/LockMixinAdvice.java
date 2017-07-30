package com.tracy.spring.basic.aop.api;


import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class LockMixinAdvice extends DefaultIntroductionAdvisor {

	private static final long serialVersionUID = -8603629718978798217L;

	public LockMixinAdvice() {
		super(new LockMixin(), Lockable.class);
	}

}
