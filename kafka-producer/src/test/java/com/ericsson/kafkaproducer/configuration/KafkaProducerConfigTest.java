//package com.ericsson.kafkaproducer.configuration;
//
//import com.ericsson.kafkaproducer.configuration.KafkaProducerConfig;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@Import(KafkaProducerConfig.class) // Import the configuration class
//class KafkaProducerConfigTest {
//
//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    @Test
//    void kafkaTemplateShouldNotBeNull() {
//        assertNotNull(kafkaTemplate, "KafkaTemplate should not be null");
//    }
//}
