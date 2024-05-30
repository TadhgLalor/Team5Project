package com.ericsson.kafkaproducer.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaultReasonTest {

    @Test
    void testEnumValues() {
        FaultReason[] reasons = FaultReason.values();
        assertEquals(4, reasons.length);
        assertEquals(FaultReason.HANDOVER_FAILED, FaultReason.valueOf("HANDOVER_FAILED"));
        assertEquals(FaultReason.NO_NETWORK_CAPACITY, FaultReason.valueOf("NO_NETWORK_CAPACITY"));
        assertEquals(FaultReason.WEAK_SIGNAL, FaultReason.valueOf("WEAK_SIGNAL"));
        assertEquals(FaultReason.UNKNOWN, FaultReason.valueOf("UNKNOWN"));
    }
}
