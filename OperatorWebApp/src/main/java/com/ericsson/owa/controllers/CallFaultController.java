package com.ericsson.owa.controllers;

import com.ericsson.owa.dao.CallFaultRepository;
import com.ericsson.owa.dto.CallFault;
import com.ericsson.owa.dto.FaultReason;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CallFaultController {

    //@Autowired

   final CallFaultRepository repository;

    CallFaultController (CallFaultRepository repository){
        this.repository=repository;
    }

    @GetMapping
    public String handleApiRequest() {
        return "API Team5 endpoint accessed successfully!";
    }

    @GetMapping("/api2")
    public String handleApiRequest2() {
        return "API Team5 endpoint 2 accessed successfully!";
    }


    @GetMapping("/failures")
    public ResponseEntity<List<CallFault>> getAllCallFaults() {
        List<CallFault> callFaultList = repository.findAll();

        if (callFaultList.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(callFaultList);
        }

    }

    @GetMapping("/failures/customer/{callerId}")
    public List<CallFault> getFailuresByCustomer(@PathVariable Integer callerId) {
        return repository.findByCallerId(callerId);
    }

    @GetMapping("/failures/node/{nodeId}")
    public List<CallFault> getFailuresByNode(@PathVariable Integer nodeId) {
        return repository.findByNodeId(nodeId);
    }

    @GetMapping("/total-failures")
    public Long getTotalFailures(){
        return repository.count();
    }

    @GetMapping("/failures/customer/{callerId}/timestamp/{timestamp}")
    public List<CallFault> getFailuresByCustomerAndTimestamp(
            @PathVariable Integer callerId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime timestamp) {
        return repository.findByCallerIdAndFaultTimestampBetween(callerId, timestamp.minusMinutes(1), timestamp.plusMinutes(1));
    }

    @GetMapping("/failures/node/{nodeId}/timestamp/{timestamp}")
    public List<CallFault> getFailuresByNodeAndTimestamp(
            @PathVariable Integer nodeId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime timestamp){
        return repository.findByNodeIdAndFaultTimestampBetween(nodeId, timestamp.minusMinutes(1), timestamp.plusMinutes(1));
    }

    @GetMapping("/failures/reason/{faultReason}")
    public List<CallFault> getFailuresByFaultReason(@PathVariable FaultReason faultReason) {
        return repository.findByFaultReason(faultReason);
    }


}


