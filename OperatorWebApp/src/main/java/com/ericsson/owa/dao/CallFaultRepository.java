package com.ericsson.owa.dao;

import com.ericsson.owa.dto.CallFault;
import com.ericsson.owa.dto.FaultReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CallFaultRepository extends JpaRepository<CallFault, Long> {

    List<CallFault> findByCallerId(Integer callerId);

    List<CallFault> findByNodeId(Integer nodeId);

    List<CallFault> findByCallerIdAndFaultTimestampBetween(Integer callerId, LocalDateTime startDate, LocalDateTime endDate);

    List<CallFault> findByNodeIdAndFaultTimestampBetween(Integer nodeId, LocalDateTime startDate, LocalDateTime endDate);

    List<CallFault> findByFaultReason(FaultReason faultReason);
}
