//package com.ericsson.kafkaproducer.configuration;
//
//import com.ericsson.kafkaproducer.dto.CallFault;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class KafkaProducerConfigTest {
//
//    @Autowired
//    private ProducerFactory<String, CallFault> producerFactory;
//
//    @Autowired
//    private KafkaTemplate<String, CallFault> kafkaTemplate;
//
//    @Test
//    void producerFactoryBeanExists() {
//        // Assert that the producerFactory bean is created
//        assertNotNull(producerFactory, "ProducerFactory bean should be created");
//
//        // Assert that the config properties are as expected
//        Map<String, Object> configProps = ((DefaultKafkaProducerFactory<String, CallFault>) producerFactory).getConfigurationProperties();
//        assertEquals("localhost:9092", configProps.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG), "Bootstrap servers should be localhost:9092");
//        assertEquals(StringSerializer.class, configProps.get(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG), "Key serializer should be StringSerializer");
//        assertEquals(CallFaultSerializer.class, configProps.get(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG), "Value serializer should be CallFaultSerializer");
//    }
//
//    @Test
//    void kafkaTemplateBeanExists() {
//        // Assert that the kafkaTemplate bean is created
//        assertNotNull(kafkaTemplate, "KafkaTemplate bean should be created");
//
//        // Assert that the kafkaTemplate uses the correct producerFactory
//        ProducerFactory<String, CallFault> factory = kafkaTemplate.getProducerFactory();
//        assertEquals(producerFactory, factory, "KafkaTemplate should use the configured ProducerFactory");
//    }
//}


package com.ericsson.kafkaproducer.configuration;

import com.ericsson.kafkaproducer.dto.CallFault;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@Import(TestKafkaProducerConfig.class)
public class KafkaProducerConfigTest {

    @Autowired
    private ProducerFactory<String, CallFault> producerFactory;

    @Autowired
    private KafkaTemplate<String, CallFault> kafkaTemplate;

    @Test
    void producerFactoryBeanExists() {
        // Assert that the producerFactory bean is created
        assertNotNull(producerFactory, "ProducerFactory bean should be created");

        // Assert that the config properties are as expected
        Map<String, Object> configProps = ((DefaultKafkaProducerFactory<String, CallFault>) producerFactory).getConfigurationProperties();
        assertEquals("localhost:9092", configProps.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG), "Bootstrap servers should be localhost:9092");
        assertEquals(StringSerializer.class, configProps.get(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG), "Key serializer should be StringSerializer");
        assertEquals(CallFaultSerializer.class, configProps.get(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG), "Value serializer should be CallFaultSerializer");
    }

    @Test
    void kafkaTemplateBeanExists() {
        // Assert that the kafkaTemplate bean is created
        assertNotNull(kafkaTemplate, "KafkaTemplate bean should be created");

        // Assert that the kafkaTemplate uses the correct producerFactory
        ProducerFactory<String, CallFault> factory = kafkaTemplate.getProducerFactory();
        assertEquals(producerFactory, factory, "KafkaTemplate should use the configured ProducerFactory");
    }
}
