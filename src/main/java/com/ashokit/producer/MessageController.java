package com.ashokit.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.producer.service.MessageReceiver;
import com.ashokit.producer.service.MessageService;

@RestController
@RequestMapping("/kafka")
public class MessageController {

	@Autowired
	MessageService service;
	
	@Autowired
	MessageReceiver receiver;
	
	@GetMapping("/sendMessage")
	public String produceMessage(@RequestParam("publish") String message)
	{
		service.sendMessage(message);
		return "Message sent to Kafka...";
	}
	
	@GetMapping("/receiveMessage")
	public String receiveMessage()
	{
		return receiver.returnMessage();
	}
}