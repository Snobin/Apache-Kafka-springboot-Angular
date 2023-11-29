package com.example.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.Payload.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class kafkajsonProducer {

	private final KafkaTemplate<String , String> kafkaTemplate;
	
	public void sendMessage(Student student) {
		Message<Student> message=MessageBuilder
				.withPayload(student)
				.setHeader(KafkaHeaders.TOPIC, "msg")
				.build();
		kafkaTemplate.send(message);
	}
}
