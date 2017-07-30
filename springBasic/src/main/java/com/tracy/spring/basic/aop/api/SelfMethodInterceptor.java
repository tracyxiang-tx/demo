package com.tracy.spring.basic.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SelfMethodInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("SelfMethodInterceptor 1:"
				+ invocation.getMethod().getName() + "  "
				+ invocation.getStaticPart().getClass().getName());
		Object obj = invocation.proceed();
		System.out.println("SelfMethodInterceptor 2: " + obj);
		return obj;
	}

}
