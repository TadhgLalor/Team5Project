package controllers;

import dao.CallFaultRepository;
import dto.CallFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CallFaultService;

import java.util.List;


@RestController
@RequestMapping("/api")

public class CallFaultController {

    @GetMapping
    public String handleApiRequest() {
        return "API Team5  endpoint accessed successfully!";
    }

    @GetMapping("/api2")
    public String handleApiRequest2() {
        return "API Team5  endpoint 2 accessed successfully!";
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
