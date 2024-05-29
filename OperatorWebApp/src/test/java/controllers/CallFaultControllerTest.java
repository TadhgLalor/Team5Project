package controllers;

import com.ericsson.owa.controllers.CallFaultController;
import com.ericsson.owa.dao.CallFaultRepository;
import com.ericsson.owa.dto.CallFault;
import com.ericsson.owa.dto.FaultReason;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CallFaultControllerTest {

    @Mock
    private CallFaultRepository repository;

    @InjectMocks
    private CallFaultController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHandleApiRequest() {
        String response = controller.handleApiRequest();
        assertEquals("API Team5 endpoint accessed successfully!", response);
    }

    @Test
    void testHandleApiRequest2() {
        String response = controller.handleApiRequest2();
        assertEquals("API Team5 endpoint 2 accessed successfully!", response);
    }

    @Test
    void testGetAllCallFaults() {
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findAll()).thenReturn(callFaults);

        ResponseEntity<List<CallFault>> responseEntity = controller.getAllCallFaults();
        List<CallFault> result = responseEntity.getBody();
    }

    @Test
    void testGetFailuresByCustomer() {
        int callerId = 1;
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByCallerId(callerId)).thenReturn(callFaults);

        List<CallFault> result = controller.getFailuresByCustomer(callerId);
        assertEquals(callFaults, result);
    }

    @Test
    void testGetFailuresByNode() {
        int nodeId = 1;
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByNodeId(nodeId)).thenReturn(callFaults);

        List<CallFault> result = controller.getFailuresByNode(nodeId);
        assertEquals(callFaults, result);
    }

    @Test
    void testGetTotalFailures() {
        long totalFailures = 5L;
        when(repository.count()).thenReturn(totalFailures);

        long result = controller.getTotalFailures();
        assertEquals(totalFailures, result);
    }

    @Test
    void testGetFailuresByCustomerAndTimestamp() {
        int callerId = 1;
        LocalDateTime timestamp = LocalDateTime.now();
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByCallerIdAndFaultTimestampBetween(callerId, timestamp.minusMinutes(1), timestamp.plusMinutes(1))).thenReturn(callFaults);

        List<CallFault> result = controller.getFailuresByCustomerAndTimestamp(callerId, timestamp);
        assertEquals(callFaults, result);
    }

    @Test
    void testGetFailuresByNodeAndTimestamp() {
        int nodeId = 1;
        LocalDateTime timestamp = LocalDateTime.now();
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByNodeIdAndFaultTimestampBetween(nodeId, timestamp.minusMinutes(1), timestamp.plusMinutes(1))).thenReturn(callFaults);

        List<CallFault> result = controller.getFailuresByNodeAndTimestamp(nodeId, timestamp);
        assertEquals(callFaults, result);
    }

    @Test
    void testGetFailuresByFaultReason() {
        FaultReason faultReason = FaultReason.HANDOVER_FAILED;
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByFaultReason(faultReason)).thenReturn(callFaults);

        List<CallFault> result = controller.getFailuresByFaultReason(faultReason);
        assertEquals(callFaults, result);

    }
}
