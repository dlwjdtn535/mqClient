package com.summit.producer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${activemq.queue.name}")
	private String queueName;

	public void send(String message) {
//		log.info( "Sending Twitter Message '{}' to destination '{}'", message, queueName );
		jmsTemplate.convertAndSend(queueName, message);
	}
}
