package com.ericsson.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "test_topic";

    @Autowired
    private KafkaTemplate<String, NodeFault> kafkaTemplate;

    public void sendMessage(NodeFault message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
