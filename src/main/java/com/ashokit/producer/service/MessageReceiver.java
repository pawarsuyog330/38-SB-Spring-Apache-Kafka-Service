package com.ashokit.producer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver {

	String message;
	
	@KafkaListener(topics="${kafka.topic.name}", groupId="grp1")
	public void receiveMessage(String message)
	{
		this.message=message;
	}
	
	public String returnMessage()
	{
		return message;
	}
}
