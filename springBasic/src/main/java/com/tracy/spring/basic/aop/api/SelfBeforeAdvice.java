package com.tracy.spring.basic.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SelfBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		
		System.out.println("BeforeAdvice: " + method.getName() + " " + target.getClass().getName());
	}

}
