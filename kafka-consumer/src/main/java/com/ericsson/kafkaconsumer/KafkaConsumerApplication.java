package com.ericsson.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.logging.Logger;

@SpringBootApplication
@EnableJpaRepositories({"dao","com.ericsson.kafkaconsumer"})
public class KafkaConsumerApplication {
    private static final Logger logger = Logger.getLogger(KafkaConsumerApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
        logger.info("KafkaConsumerApplication running...");
    }
}
