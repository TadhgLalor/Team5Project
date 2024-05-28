package com.ericsson.kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumerService {


    CallFaultRepository callFaultRepository;

    KafkaConsumerService  (CallFaultRepository callFaultRepository){
        this.callFaultRepository=callFaultRepository;
    }

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consume(CallFault message) {
        System.out.println("Consumed message: " + message.toString());
       callFaultRepository.save(message);
    }
}
