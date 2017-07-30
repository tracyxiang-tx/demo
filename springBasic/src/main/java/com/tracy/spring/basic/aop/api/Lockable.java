package com.tracy.spring.basic.aop.api;

public interface Lockable {

	void lock();
	void unlock();
	boolean locked();
}
