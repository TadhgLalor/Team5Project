package com.ericsson.kafkaconsumer.service;

import com.ericsson.kafkaconsumer.CallFault;
import com.ericsson.kafkaconsumer.FaultReason;
import com.ericsson.kafkaconsumer.KafkaConsumerService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.kafka.consumer.group-id=group_id",
        "spring.kafka.bootstrap-servers=localhost:9092"
})
class KafkaConsumerServiceTest {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @MockBean
    private KafkaConsumerService kafkaConsumerServiceMock;

    @Test
    void testConsume() {
        int nodeId = 1;
        int networkId = 100;
        String networkName = "TestNetwork";
        int callerId = 12345;
        String callerName = "John Doe";
        FaultReason faultReason = FaultReason.NO_NETWORK_CAPACITY;
        LocalDateTime faultTimestamp = LocalDateTime.of(2023, 5, 27, 14, 30, 0);

        CallFault callFault = new CallFault(nodeId, networkId, networkName, callerId, callerName, faultReason, faultTimestamp);

        // Simulate Kafka consumer receiving the message
        kafkaConsumerService.consume(callFault);

        // Verify the consume method was called with the expected argument
        ArgumentCaptor<CallFault> captor = ArgumentCaptor.forClass(CallFault.class);
        verify(kafkaConsumerServiceMock).consume(captor.capture());

        CallFault consumedMessage = captor.getValue();
        assertEquals(callFault.toString(), consumedMessage.toString());
    }
}
