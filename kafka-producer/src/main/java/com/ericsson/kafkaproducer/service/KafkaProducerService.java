package com.ericsson.kafkaproducer.service;

import com.ericsson.kafkaproducer.dto.CallFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "test_topic";

    @Autowired
    private KafkaTemplate<String, CallFault> kafkaTemplate;

    public void sendMessage(CallFault message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
