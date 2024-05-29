package com.ericsson.kafkaproducer.service;

import com.ericsson.kafkaproducer.dto.CallFault;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "test_topic";

    @Autowired KafkaTemplate<String, CallFault> kafkaTemplate;

    public void sendMessage(CallFault message) {
        kafkaTemplate.send(TOPIC, message);
    }
    
    @PreDestroy
    public void close() {
        if (kafkaTemplate != null) {
            kafkaTemplate.flush();
            kafkaTemplate.destroy();
        }
    }
}
