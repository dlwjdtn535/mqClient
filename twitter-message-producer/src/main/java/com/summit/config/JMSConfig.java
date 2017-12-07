package com.summit.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JMSConfig {

	@Value("${activemq.broker.url}")
	private String brokerUrl;
	@Value("${activemq.broker.user}")
	private String brokerUser;
	@Value("${activemq.broker.password}")
	private String brokerPassword;

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory( brokerUser, brokerPassword, brokerUrl );
		return new CachingConnectionFactory(factory);
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(cachingConnectionFactory());
	}
}
