package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.Payload.Student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class kafkaConsumer {

	@KafkaListener(topics = "msg",groupId = "myGroup")
	public void consumemsg(String msg) {
		log.info(String.format("consuming msg from msg topic:: %s",msg));
	}
	@KafkaListener(topics = "msg",groupId = "myGroup")
	public void consumejsonmsg(Student msg) {
		log.info(String.format("consuming msg from msg topic:: %s",msg.toString()));
	}
}
