package com.example.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class kafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String msg) {
		log.info(String.format("send to msg Topic", msg));
		kafkaTemplate.send("msg",msg);
	}
	
}
