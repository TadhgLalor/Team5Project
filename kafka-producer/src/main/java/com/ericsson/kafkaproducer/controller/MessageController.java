package com.ericsson.kafkaproducer.controller;

import com.ericsson.kafkaproducer.dto.CallFault;
import com.ericsson.kafkaproducer.dto.FaultReason;
import com.ericsson.kafkaproducer.service.KafkaProducerService;
import com.ericsson.kafkaproducer.service.RandomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private KafkaProducerService producerService;

    @Autowired
    private RandomMessageService randomMessageService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("nodeId") int nodeId, @RequestParam("networkId") int networkId,
                              @RequestParam("networkName") String networkName, @RequestParam("callerId") int callerId,
                              @RequestParam("callerName") String callerName, @RequestParam("faultReason") FaultReason faultReason) {
        CallFault message = new CallFault(nodeId, networkId, networkName, callerId, callerName, faultReason);
        System.out.println("Entered URI");
        producerService.sendMessage(message);
        return "Message sent to Kafka topic";
    }

    @GetMapping("/sendRandom")
    public String sendRandomMessage(int nodeId) {
        CallFault randomMessage = randomMessageService.generateRandomFaultMessage();
        randomMessage.setNodeId(nodeId);
        producerService.sendMessage(randomMessage);
        return "Random Fault Message sent to Kafka topic";
    }
}