package com.ericsson.kafkaproducer.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CallFaultTest {

    @Test
    void testCallFaultInitialization() {
        int nodeId = 1;
        int networkId = 2;
        String networkName = "TestNetwork";
        int callerId = 3;
        String callerName = "TestCaller";
        FaultReason faultReason = FaultReason.HANDOVER_FAILED;

        CallFault callFault = new CallFault(nodeId, networkId, networkName, callerId, callerName, faultReason);

        assertEquals(nodeId, callFault.getNodeId());
        assertEquals(networkId, callFault.getNetworkId());
        assertEquals(networkName, callFault.getNetworkName());
        assertEquals(callerId, callFault.getCallerId());
        assertEquals(callerName, callFault.getCallerName());
        assertEquals(faultReason, callFault.getFaultReason());
        assertNotNull(callFault.getFaultTimestamp());
        assertTrue(callFault.getFaultTimestamp().isBefore(LocalDateTime.now().plusSeconds(1)));
    }
}
