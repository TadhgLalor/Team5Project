package com.ericsson.kafkaproducer.service;

import com.ericsson.kafkaproducer.dto.CallFault;
import com.ericsson.kafkaproducer.dto.FaultReason;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

class KafkaProducerServiceTest {

    private KafkaTemplate<String, CallFault> kafkaTemplate;
    private KafkaProducerService kafkaProducerService;

    @BeforeEach
    void setUp() {
        kafkaTemplate = Mockito.mock(KafkaTemplate.class);
        kafkaProducerService = new KafkaProducerService();
        kafkaProducerService.kafkaTemplate = kafkaTemplate;
    }

    @Test
    void testSendMessage() {
        CallFault callFault = new CallFault(1, 2, "Network", 3, "Caller", FaultReason.HANDOVER_FAILED);
        kafkaProducerService.sendMessage(callFault);
        verify(kafkaTemplate, times(1)).send("test_topic", callFault);
    }
}
