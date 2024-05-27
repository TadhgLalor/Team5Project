package dao;

import com.ericsson.kafkaconsumer.CallFault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CallFaultRepository extends JpaRepository<CallFault, Long> {
}
