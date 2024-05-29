// KafkaProducerConfig.java
package com.ericsson.kafkaproducer.configuration;

import com.ericsson.kafkaproducer.dto.CallFault;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

//    private final KafkaProperties kafkaProperties;
//
//    @Autowired
//    public KafkaProducerConfig(KafkaProperties kafkaProperties) {
//        this.kafkaProperties = kafkaProperties;
//    }

    @Bean
    public ProducerFactory<String, CallFault> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        // get configs on application.properties/yml
        // Map<String, Object> properties = kafkaProperties.buildProducerProperties();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka_docker:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CallFaultSerializer.class);
//        configProps.put("metadata.max.age.ms", "30000");
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, CallFault> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

//    @Bean
//    public NewTopic topic() {
//        return TopicBuilder
//                .name("test_topic")
//                .partitions(1)
//                .replicas(1)
//                .build();
//    }

}
