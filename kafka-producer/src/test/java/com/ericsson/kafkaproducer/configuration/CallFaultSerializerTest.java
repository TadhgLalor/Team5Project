package com.ericsson.kafkaproducer.configuration;

import com.ericsson.kafkaproducer.dto.CallFault;
import com.ericsson.kafkaproducer.dto.FaultReason;
import org.apache.kafka.common.errors.SerializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CallFaultSerializerTest {

    private CallFaultSerializer callFaultSerializer;

    @BeforeEach
    void setUp() {
        callFaultSerializer = new CallFaultSerializer();
    }

    @Test
    void testSerialize_nullObject() {
        byte[] result = callFaultSerializer.serialize("test_topic", null);
        assertNull(result);
    }

    @Test
    void testSerialize_validObject() {
        CallFault callFault = new CallFault(1, 2, "Network", 3, "Caller", FaultReason.HANDOVER_FAILED);
        byte[] result = callFaultSerializer.serialize("test_topic", callFault);
        assertNotNull(result);
    }

    @Test
    void testSerialize_exceptionThrown() {
        CallFault faultyCallFault = new CallFault(1, 2, "Network", 3, "Caller", FaultReason.HANDOVER_FAILED) {
            @Override
            public String getCallerName() {
                throw new RuntimeException("Serialization error");
            }
        };

        assertThrows(SerializationException.class, () -> {
            callFaultSerializer.serialize("test_topic", faultyCallFault);
        });
    }
}
