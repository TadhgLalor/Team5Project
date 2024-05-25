package com.ericsson.kafkaproducer;


import org.springframework.stereotype.Component;


public class NodeFault {
    private int nodeId;
    private int networkId;

    public NodeFault(int nodeId, int networkId) {
        this.nodeId = nodeId;
        this.networkId = networkId;
    }

    public int getNetworkId() {
        return networkId;
    }

    public int getNodeId() {
        return nodeId;
    }
}
