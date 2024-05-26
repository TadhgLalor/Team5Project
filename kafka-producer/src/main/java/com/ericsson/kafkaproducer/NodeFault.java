package com.ericsson.kafkaproducer;


import org.springframework.stereotype.Component;


public class NodeFault {
    private int nodeId;
    private int networkId;
    private String networkName;
    private int callerId;
    private String callerName;
    private FaultReason faultReason;

    public NodeFault(int nodeId, int networkId, String networkName,int callerId, String callerName,
                     FaultReason faultReason) {
        this.nodeId = nodeId;
        this.networkId = networkId;
        this.networkName=networkName;
        this.callerId=callerId;
        this.callerName=callerName;
        this.faultReason=faultReason;
    }

    public int getNetworkId() {
        return networkId;
    }

    public int getNodeId() {
        return nodeId;
    }

    public int getCallerId() {
        return callerId;
    }

    public String getCallerName() {
        return callerName;
    }

    public String getNetworkName() {
        return networkName;
    }

    public FaultReason getFaultReason() {
        return faultReason;
    }
}