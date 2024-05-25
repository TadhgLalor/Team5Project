package com.ericsson.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("nodeId") int nodeId, @RequestParam("networkId") int networkId) {
        NodeFault message = new NodeFault(nodeId, networkId);
        System.out.println("Entered URI");
        producerService.sendMessage(message);
        return "Message sent to Kafka topic";
    }





}

