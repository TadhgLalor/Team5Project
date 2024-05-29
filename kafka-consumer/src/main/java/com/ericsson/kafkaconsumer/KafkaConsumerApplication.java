package com.ericsson.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"dao","com.ericsson.kafkaconsumer"})
public class KafkaConsumerApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(KafkaConsumerApplication.class, args);
        System.out.println("Waiting for producer and database to be ready...");
        Thread.sleep(50000); // Wait for 50 seconds to ensure producer is ready
    }

}
