package controllers;

import dao.CallFaultRepository;
import dto.CallFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CallFaultService;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")

public class CallFaultController {

    @Autowired
    private CallFaultRepository repository;

    @GetMapping
    public String handleApiRequest() {
        return "API Team5  endpoint accessed successfully!";
    }

    @GetMapping("/api2")
    public String handleApiRequest2() {
        return "API Team5  endpoint 2 accessed successfully!";
    }

    @GetMapping("/failures")
    public List<CallFault> getAllCallFaults() {
        return repository.findAll();
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



}


    /*@RestController
    @RequestMapping("/api")
    public class CallFaultController {


        @Autowired
        private CallFaultService callFaultService;


        @GetMapping("/total-failures")
        public Long getTotalFailures() {
            return callFaultService.getTotalFailures();
        }


        @GetMapping("/failures/customer/{callerId}")
        public List<CallFault> getFailuresByCustomer(@PathVariable Integer callerId) {
            return callFaultService.getFailuresByCustomer(callerId);
        }

        @GetMapping("/failures/node/{nodeId}")
        public List<CallFault> getFailuresByNode(@PathVariable Integer nodeId) {
            return callFaultService.getFailuresByNode(nodeId);
        }
    }


/*@RestController
@RequestMapping("/api")

public class CallFaultController {

    @Autowired
    private CallFaultRepository repository;



    @GetMapping("/total-failures")
    public Long getTotalFailures(){
        return repository.count();
    }

    @GetMapping("/failures/customer/{callerId}")
    public List<CallFault> getFailuresByCustomer(@PathVariable Integer callerId) {
        return repository.findByCallerId(callerId);
    }

    @GetMapping("/failures/node/{nodeId}")
    public List<CallFault> getFailuresByNode(@PathVariable Integer nodeId) {
        return repository.findByNodeId(nodeId);
    }

    @GetMapping("/failures/customer/{callerId}/period/{startDate}/{endDate}")
    public List<CallFault> getFailuresByCustomerAndPeriod(
            @PathVariable Integer callerId,
            @PathVariable LocalDateTime startDate,
            @PathVariable LocalDateTime endDate) {
        return repository.findByCallerIdAndFaultTimestampBetween(callerId, startDate, endDate);
    }

    @GetMapping("/failures/node/{nodeId}/period/{startDate}/{endDate}")
    public List<CallFault> getFailuresByNodeAndPeriod(
            @PathVariable Integer nodeId,
            @PathVariable LocalDateTime startDate,
            @PathVariable LocalDateTime endDate) {
        return repository.findByNodeIdAndFaultTimestampBetween(nodeId, startDate, endDate);
    }
*/
