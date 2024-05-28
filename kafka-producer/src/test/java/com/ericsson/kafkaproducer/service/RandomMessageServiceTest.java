package com.ericsson.kafkaproducer.service;

import com.ericsson.kafkaproducer.dto.CallFault;
import com.ericsson.kafkaproducer.dto.FaultReason;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMessageServiceTest {

    private RandomMessageService randomMessageService;

    @BeforeEach
    void setUp() {
        randomMessageService = new RandomMessageService();
    }

    @Test
    void testGenerateRandomFaultMessage() {
        CallFault callFault = randomMessageService.generateRandomFaultMessage();
        assertNotNull(callFault);
        assertTrue(callFault.getNodeId() >= 0 && callFault.getNodeId() < 5);
        assertTrue(callFault.getNetworkId() >= 0 && callFault.getNetworkId() < 1000);
        assertNotNull(callFault.getNetworkName());
        assertTrue(callFault.getCallerId() >= 0 && callFault.getCallerId() < 1000);
        assertNotNull(callFault.getCallerName());
        assertNotNull(callFault.getFaultReason());
        assertNotNull(callFault.getFaultTimestamp());
    }
}
