package controllers;

import dao.CallFaultRepository;
import dto.CallFault;
import dto.FaultReason;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CallFaultControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CallFaultRepository repository;

    @InjectMocks
    private CallFaultController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHandleApiRequest() throws Exception {
        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().string("API Team5  endpoint accessed successfully!"));
    }

    @Test
    public void testHandleApiRequest2() throws Exception {
        mockMvc.perform(get("/api2"))
                .andExpect(status().isOk())
                .andExpect(content().string("API Team5  endpoint 2 accessed successfully!"));
    }

    @Test
    public void testGetAllCallFaults() throws Exception {
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findAll()).thenReturn(callFaults);

        mockMvc.perform(get("/failures"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));

        verify(repository, times(1)).findAll();
    }

    @Test
    public void testGetFailuresByCustomer() throws Exception {
        Integer callerId = 1;
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByCallerId(callerId)).thenReturn(callFaults);

        mockMvc.perform(get("/failures/customer/{callerId}", callerId))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));

        verify(repository, times(1)).findByCallerId(callerId);
    }

    @Test
    public void testGetFailuresByNode() throws Exception {
        Integer nodeId = 1;
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByNodeId(nodeId)).thenReturn(callFaults);

        mockMvc.perform(get("/failures/node/{nodeId}", nodeId))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));

        verify(repository, times(1)).findByNodeId(nodeId);
    }

    @Test
    public void testGetTotalFailures() throws Exception {
        Long totalFailures = 10L;
        when(repository.count()).thenReturn(totalFailures);

        mockMvc.perform(get("/total-failures"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));

        verify(repository, times(1)).count();
    }

    @Test
    public void testGetFailuresByCustomerAndTimestamp() throws Exception {
        Integer callerId = 1;
        LocalDateTime timestamp = LocalDateTime.of(2023, 5, 28, 12, 0, 0);
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByCallerIdAndFaultTimestampBetween(callerId, timestamp.minusMinutes(1), timestamp.plusMinutes(1)))
                .thenReturn(callFaults);

        mockMvc.perform(get("/failures/customer/{callerId}/timestamp/{timestamp}", callerId, timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));

        verify(repository, times(1)).findByCallerIdAndFaultTimestampBetween(callerId, timestamp.minusMinutes(1), timestamp.plusMinutes(1));
    }

    @Test
    public void testGetFailuresByNodeAndTimestamp() throws Exception {
        Integer nodeId = 1;
        LocalDateTime timestamp = LocalDateTime.of(2023, 5, 28, 12, 0, 0);
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByNodeIdAndFaultTimestampBetween(nodeId, timestamp.minusMinutes(1), timestamp.plusMinutes(1)))
                .thenReturn(callFaults);

        mockMvc.perform(get("/failures/node/{nodeId}/timestamp/{timestamp}", nodeId, timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));

        verify(repository, times(1)).findByNodeIdAndFaultTimestampBetween(nodeId, timestamp.minusMinutes(1), timestamp.plusMinutes(1));
    }

    @Test
    public void testGetFailuresByFaultReason() throws Exception {
        FaultReason faultReason = FaultReason.HANDOVER_FAILED;
        List<CallFault> callFaults = Arrays.asList(new CallFault(), new CallFault());
        when(repository.findByFaultReason(faultReason)).thenReturn(callFaults);

        mockMvc.perform(get("/failures/reason/{faultReason}", faultReason))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));

        verify(repository, times(1)).findByFaultReason(faultReason);
    }
}

