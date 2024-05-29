package com.ericsson.kafkaproducer.service;

import com.ericsson.kafkaproducer.dto.CallFault;
import com.ericsson.kafkaproducer.dto.FaultReason;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.UUID;

@Service
public class RandomMessageService {

    private final SecureRandom secureRandom = new SecureRandom();

    public CallFault generateRandomFaultMessage(){

        int nodeId = secureRandom.nextInt(5);      //Between 0-999
        int networkId = secureRandom.nextInt(1000);
        String networkName = randomNetworkName(networkId);
        int callerId = secureRandom.nextInt(1000);
        String callerName = randomomString();
        // Random FaultReason enum value
        FaultReason faultReason = randomFaultReason();

        return new CallFault(nodeId, networkId, networkName, callerId, callerName, faultReason);
    }

    private String randomomString() {
        return UUID.randomUUID().toString();
    }

    private FaultReason randomFaultReason() {
        FaultReason[] reasons = FaultReason.values();
        return reasons[secureRandom.nextInt(reasons.length)];
    }

    private String randomNetworkName(int networkId) {
        if (networkId <= 249) {
            return "Vodafone";
        } else if (networkId <= 500) {
            return "Eir";
        } else if (networkId <= 750) {
            return "Virgin Mobile Ireland";
        } else if (networkId <= 999) {
            return "Tesco Mobile Ireland";
        } else {
            return "Invalid Network ID";
        }
    }
}