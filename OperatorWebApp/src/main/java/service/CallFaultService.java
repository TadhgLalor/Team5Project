package service;

import dao.CallFaultRepository;
import dto.CallFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CallFaultService {

    @Autowired
    private CallFaultRepository repository;

    public Long getTotalFailures() {
        return repository.count();
    }

    public List<CallFault> getFailuresByCustomer(Integer callerId) {
        return repository.findByCallerId(callerId);
    }

    public List<CallFault> getFailuresByNode(Integer nodeId) {
        return repository.findByNodeId(nodeId);
    }
}

