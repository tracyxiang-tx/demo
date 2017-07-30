package com.tracy.spring.basic.bean;

public class StringStore implements Store {

	public void init() {
		System.out.println("This is init method!");
	}
	public void destroy() {
		System.out.println("This is destroy method!");
	}
}
