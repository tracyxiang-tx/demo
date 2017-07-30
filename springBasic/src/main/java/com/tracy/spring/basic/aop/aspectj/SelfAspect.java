package com.tracy.spring.basic.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SelfAspect {

	@Pointcut("execution(* com.tracy.spring.basic.aop.aspectj.*Biz.*(..))")
	public void pointcut() {
		
	}
	
	@Pointcut("execution(* com.tracy.spring.basic.aop.aspectj.*Biz.*(..)) && @annotation(selfMethod)")
	public void pointcutAnnotation(SelfMethod selfMethod) {
		
	}
	
	@Pointcut("within(com.tracy.spring.basic.aop.aspectj.*)")
	public void bizPointcut() {
		
	}
	
	//@Before("execution(* com.tracy.spring.basic.aop.aspectj.*Biz.*(..))")
	@Before("pointcut()")
	public void before() {
		System.out.println("SelfAspect before.");
	}
	
	@Before("pointcut() && args(arg)")
	public void beforeWithParam(String arg) {
		System.out.println("SelfAspect beforeWithParam. " + arg);
	}
	
	//@Before("pointcut() && @annotation(selfMethod)")
	@Before("pointcutAnnotation(selfMethod)")
	public void beforeWithAnnotation(SelfMethod selfMethod) {
		System.out.println("SelfAspect beforeWithAnnotation. " + selfMethod.value());
	}
	
	@AfterReturning(pointcut = "bizPointcut()", returning="returnValue" )
	public void afterReturning(Object returnValue) {
		System.out.println("SelfAspect afterReturning: " + returnValue);
	}
	
	@AfterThrowing(pointcut = "pointcut()", throwing="e" )
	public void afterThrowing(RuntimeException e) {
		System.out.println("SelfAspect afterThrowing: " + e.getMessage());
	}
	
	@After("pointcut()")
	public void after() {
		System.out.println("SelfAspect after");
	}
	 
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable  {
		System.out.println("SelfAspect around 1");
		
		Object obj = pjp.proceed();
		
		System.out.println("SelfAspect around 2");
		
		System.out.println("SelfAspect around : " + obj);
		return obj;
		
	}
}
