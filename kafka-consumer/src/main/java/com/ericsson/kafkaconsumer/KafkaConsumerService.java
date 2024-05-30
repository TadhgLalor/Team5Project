package com.ericsson.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;


@Service
public class KafkaConsumerService {
    private static final Logger logger = Logger.getLogger(KafkaConsumerApplication.class.getName());

    CallFaultRepository callFaultRepository;

    KafkaConsumerService  (CallFaultRepository callFaultRepository){
        this.callFaultRepository=callFaultRepository;
    }

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consume(CallFault message) {
        logger.info("Consumed message: " + message.toString());
       callFaultRepository.save(message);
    }
}
