package com.ericsson.kafkaproducer;

import com.ericsson.kafkaproducer.dto.CallFault;
import com.ericsson.kafkaproducer.service.RandomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {



    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
        System.out.println("KafkaProducerApplication running...");
    }
}
