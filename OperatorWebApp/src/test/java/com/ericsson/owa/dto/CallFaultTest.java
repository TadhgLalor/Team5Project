package com.ericsson.owa.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class CallFaultTest {

    @Test
    public void testGettersAndSetters() {
        CallFault callFault = new CallFault();

        Long id = 1L;
        callFault.setId(id);
        assertEquals(id, callFault.getId());

        Integer nodeId = 123;
        callFault.setNodeId(nodeId);
        assertEquals(nodeId, callFault.getNodeId());

        Integer networkId = 456;
        callFault.setNetworkId(networkId);
        assertEquals(networkId, callFault.getNetworkId());

        String networkName = "TestNetwork";
        callFault.setNetworkName(networkName);
        assertEquals(networkName, callFault.getNetworkName());

        Integer callerId = 789;
        callFault.setCallerId(callerId);
        assertEquals(callerId, callFault.getCallerId());

        String callerName = "TestCaller";
        callFault.setCallerName(callerName);
        assertEquals(callerName, callFault.getCallerName());

        FaultReason faultReason = FaultReason.HANDOVER_FAILED;
        callFault.setFaultReason(faultReason);
        assertEquals(faultReason, callFault.getFaultReason());

        LocalDateTime faultTimestamp = LocalDateTime.now();
        callFault.setFaultTimestamp(faultTimestamp);
        assertEquals(faultTimestamp, callFault.getFaultTimestamp());
    }
}
