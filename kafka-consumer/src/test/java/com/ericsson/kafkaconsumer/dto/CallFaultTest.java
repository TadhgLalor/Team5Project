package com.ericsson.kafkaconsumer.dto;

import com.ericsson.kafkaconsumer.CallFault;
import com.ericsson.kafkaconsumer.FaultReason;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallFaultTest {

    @Test
    public void testCallFaultConstructorAndGetters() {
        int nodeId = 1;
        int networkId = 100;
        String networkName = "TestNetwork";
        int callerId = 12345;
        String callerName = "John Doe";
        FaultReason faultReason = FaultReason.NO_NETWORK_CAPACITY; // Assuming FaultReason is an enum or a class with predefined values
        LocalDateTime faultTimestamp = LocalDateTime.of(2023, 5, 27, 14, 30, 0);

        CallFault callFault = new CallFault(nodeId, networkId, networkName, callerId, callerName, faultReason, faultTimestamp);

        assertEquals(nodeId, callFault.getNodeId());
        assertEquals(networkId, callFault.getNetworkId());
        assertEquals(networkName, callFault.getNetworkName());
        assertEquals(callerId, callFault.getCallerId());
        assertEquals(callerName, callFault.getCallerName());
        assertEquals(faultReason, callFault.getFaultReason());
    }

    @Test
    public void testCallFaultJsonSerialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        int nodeId = 1;
        int networkId = 100;
        String networkName = "TestNetwork";
        int callerId = 12345;
        String callerName = "John Doe";
        FaultReason faultReason = FaultReason.NO_NETWORK_CAPACITY;
        LocalDateTime faultTimestamp = LocalDateTime.of(2023, 5, 27, 14, 30, 0);

        CallFault callFault = new CallFault(nodeId, networkId, networkName, callerId, callerName, faultReason, faultTimestamp);

        String json = mapper.writeValueAsString(callFault);

        String expectedJson = "{\"nodeId\":1,\"networkId\":100,\"networkName\":\"TestNetwork\",\"callerId\":12345,\"callerName\":\"John Doe\",\"faultReason\":\"NO_NETWORK_CAPACITY\",\"faultTimestamp\":\"27-05-2023 14:30:00\"}";

        assertEquals(expectedJson, json);
    }

    @Test
    public void testCallFaultJsonDeserialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String json = "{\"nodeId\":1,\"networkId\":100,\"networkName\":\"TestNetwork\",\"callerId\":12345,\"callerName\":\"John Doe\",\"faultReason\":\"NO_NETWORK_CAPACITY\",\"faultTimestamp\":\"27-05-2023 14:30:00\"}";

        CallFault callFault = mapper.readValue(json, CallFault.class);

        assertEquals(1, callFault.getNodeId());
        assertEquals(100, callFault.getNetworkId());
        assertEquals("TestNetwork", callFault.getNetworkName());
        assertEquals(12345, callFault.getCallerId());
        assertEquals("John Doe", callFault.getCallerName());
        assertEquals(FaultReason.NO_NETWORK_CAPACITY, callFault.getFaultReason());
        
        String expectedToString = "###########CallFault############{" +
                "networkId=100" +
                "NodeID= 1" +
                "NetworkName= TestNetwork" +
                "Caller ID= 12345" +
                "Caller Name= John Doe" +
                "Fault Reason = NO_NETWORK_CAPACITY" +
                "Fault Time = 2023-05-27T14:30" +
                '}';

        assertEquals(expectedToString, callFault.toString());
    }
}
