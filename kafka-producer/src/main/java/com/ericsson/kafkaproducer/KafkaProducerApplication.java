package com.ericsson.kafkaproducer;

import com.ericsson.kafkaproducer.dto.CallFault;
import com.ericsson.kafkaproducer.service.RandomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ericsson.kafkaproducer.controller.MessageController;

@SpringBootApplication
public class KafkaProducerApplication implements ApplicationRunner {

    @Autowired
    private MessageController messageController;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
        System.out.println("KafkaProducerApplication running...");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Sending random messages on startup...");
        boolean keepRunning = true; // Control variable for the loop

        while (keepRunning) {
            messageController.sendRandomMessage();
            Thread.sleep(5000); // Sleep for 5 seconds before sending the next message

            // Implement a condition to break the loop if needed
            // For example, you could check for a specific condition or input
            // keepRunning = checkIfShouldStop();
        }
    }
}
