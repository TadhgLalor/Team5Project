package com.ericsson.kafkaconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class KafkaConsumerApplicationTests {

    @Test
    void contextLoads() {
        // Test to ensure the Spring application context loads successfully
        assertDoesNotThrow(() -> {
            // If the application context fails to load, this test will throw an exception
            SpringApplication.run(KafkaConsumerApplication.class);
        });
    }
}
