package com.tracy.test.jms.spring.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerServiceImpl implements ProducerService {

	@Autowired
	JmsTemplate jmsTemplate;
	
	//@Resource(name="queueDestination")
	@Resource(name="topicDestination")
	Destination destination;
	
	//使用JMSTemplate发送消息
	public void sendMessage(final String message) {
		jmsTemplate.send(destination,new MessageCreator() {
			//创建一个消息
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(message);
				
				return textMessage;
			}
		});
		System.out.println("发送消息: " + message);
	}

}
