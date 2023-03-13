package com.ashokit.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka.topic.name}")
	String topicName;
	
	public void sendMessage(String message)
	{
	kafkaTemplate.send(topicName, message);
	}
}