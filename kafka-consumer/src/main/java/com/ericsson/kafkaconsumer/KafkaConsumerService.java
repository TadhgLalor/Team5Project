package com.ericsson.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consume(NodeFault message) {
        System.out.println("Consumed message: " + message.toString());
    }
}
