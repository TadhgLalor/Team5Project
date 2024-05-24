package dao;

import dto.CallFault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallFaultRepository extends JpaRepository <CallFault, Long> {

    List<CallFault> findByCallerId(Integer callerId);
    List<CallFault> findByNodeId(Integer nodeId);
}
