package com.ericsson.kafkaconsumer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeFault {
    private int nodeId;
    private int networkId;


    public NodeFault(@JsonProperty("nodeId") int nodeId, @JsonProperty("networkId") int networkId) {
        this.nodeId = nodeId;
        this.networkId = networkId;
    }


    public int getNetworkId() {
        return networkId;
    }

    public int getNodeId() {
        return nodeId;
    }

    @Override
    public String toString() {
        return "###########NodeFault############{" +
                "networkId=" + networkId +
                "NodeID= "+nodeId+
                '}';
    }
}
