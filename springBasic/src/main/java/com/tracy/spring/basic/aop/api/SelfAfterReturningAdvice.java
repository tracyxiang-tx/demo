package com.tracy.spring.basic.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SelfAfterReturningAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object Target) throws Throwable {

		System.out.println("SelfAfterReturningAdvice: " + method.getName()
				+ "  " + Target.getClass().getName() + "  " + returnValue);
	}

}
