package com.tracy.spring.basic.jsr;

import org.springframework.stereotype.Repository;

@Repository
public class JsrDao {

	public void save() {
		System.out.println("jsrDao save method!");
	}
}
