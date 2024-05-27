package com.ericsson.kafkaconsumer.service;

import com.ericsson.kafkaconsumer.dto.CallFault;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consume(CallFault message) {
        System.out.println("Consumed message: " + message.toString());
    }
}
