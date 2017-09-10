package com.tracy.test.jms.spring.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:producer.xml");
		ProducerService service = context.getBean(ProducerService.class);
		
		for (int i = 0; i < 100; i++) {
			service.sendMessage("test" + i);
		}
		
		context.close();
		
	}
}
