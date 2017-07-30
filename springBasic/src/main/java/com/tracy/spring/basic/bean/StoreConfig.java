package com.tracy.spring.basic.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfig {

	@Bean(name="store", initMethod="init", destroyMethod="destroy")
	public Store stringStore(){
		return new StringStore();
	}
}
