package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Payload.Student;
import com.example.demo.producer.kafkaProducer;
import com.example.demo.producer.kafkajsonProducer;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class kafkaController {
	private final kafkaProducer kafkaProducer;
	private final kafkajsonProducer kafkajsonProducer;
	@PostMapping("/text")
	public ResponseEntity<String> sendMessage( @RequestBody String message ){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message 	queued successfully");
		
	}
	@PostMapping("/json")
	public ResponseEntity<String> sendMessage( @RequestBody Student message ){
		kafkajsonProducer.sendMessage(message);
		return ResponseEntity.ok("Message queued successfully as json");
		
	}
	
}
