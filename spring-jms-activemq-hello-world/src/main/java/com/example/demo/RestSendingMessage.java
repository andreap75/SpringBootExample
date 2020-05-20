package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSendingMessage {
	@Autowired
	private MessageSender messagingProducerConfiguration;

	@RequestMapping("hello")
	public String home(){
	    messagingProducerConfiguration.send("dfgdf");
	    return "Welcome come Spring Boot with Wildfly";
	}
}
