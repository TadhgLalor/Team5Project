package com.ericsson.kafkaconsumer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeFault {
    private int nodeId;
    private int networkId;
    private String networkName;
    private int callerId;
    private String callerName;
    private FaultReason faultReason;



    public NodeFault(@JsonProperty("nodeId") int nodeId, @JsonProperty("networkId") int networkId,
                     @JsonProperty("networkName") String networkName,@JsonProperty("callerId") int callerId,
                     @JsonProperty("callerName") String callerName,@JsonProperty("faultReason")FaultReason faultReason) {
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

    @Override
    public String toString() {
        return "###########NodeFault############{" +
                "networkId=" + networkId +
                "NodeID= "+nodeId+
                "NetworkName= "+networkName+
                "Caller ID= "+callerId+
                "Caller Name= "+callerName+
                "Fault Reason = "+faultReason+
                '}';
    }
}