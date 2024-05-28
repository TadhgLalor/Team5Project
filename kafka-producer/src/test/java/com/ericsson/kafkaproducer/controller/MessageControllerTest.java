package com.ericsson.kafkaproducer.controller;

import com.ericsson.kafkaproducer.dto.CallFault;
import com.ericsson.kafkaproducer.dto.FaultReason;
import com.ericsson.kafkaproducer.service.KafkaProducerService;
import com.ericsson.kafkaproducer.service.RandomMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MessageControllerTest {

    @Mock
    private KafkaProducerService producerService;

    @Mock
    private RandomMessageService randomMessageService;

    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendMessage() {
        // Arrange
        int nodeId = 123;
        int networkId = 456;
        String networkName = "Test Network";
        int callerId = 789;
        String callerName = "Test Caller";
        FaultReason faultReason = FaultReason.NO_NETWORK_CAPACITY;

        CallFault expectedMessage = new CallFault(nodeId, networkId, networkName, callerId, callerName, faultReason);

        // Act
        String result = messageController.sendMessage(nodeId, networkId, networkName, callerId, callerName, faultReason);

        // Assert
        assertEquals("Message sent to Kafka topic", result, "Response should be as expected");
        verify(producerService, times(1)).sendMessage(any(CallFault.class));
    }
    
    @Test
    void sendRandomMessage() {
        // Arrange
        CallFault mockCallFault = new CallFault(123, 456, "TestNetwork", 789, "TestCaller", FaultReason.HANDOVER_FAILED);
        when(randomMessageService.generateRandomFaultMessage()).thenReturn(mockCallFault);

        // Act
        messageController.sendRandomMessage();

        // Assert
        verify(randomMessageService, times(1)).generateRandomFaultMessage();
        verify(producerService, times(1)).sendMessage(mockCallFault);
    }


}
