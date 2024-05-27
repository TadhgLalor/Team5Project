package com.ericsson.kafkaconsumer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

public class CallFault {
    private int nodeId;
    private int networkId;
    private String networkName;
    private int callerId;
    private String callerName;
    private FaultReason faultReason;

    @JsonDeserialize (using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime faultTimestamp;


    public CallFault(@JsonProperty("nodeId") int nodeId, @JsonProperty("networkId") int networkId,
                     @JsonProperty("networkName") String networkName,@JsonProperty("callerId") int callerId,
                     @JsonProperty("callerName") String callerName,@JsonProperty("faultReason")FaultReason faultReason,
                     @JsonProperty("faultTimestamp") LocalDateTime faultTimestamp) {
        this.nodeId = nodeId;
        this.networkId = networkId;
        this.networkName=networkName;
        this.callerId=callerId;
        this.callerName=callerName;
        this.faultReason=faultReason;
        this.faultTimestamp=faultTimestamp;
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
        return "###########CallFault############{" +
                "networkId=" + networkId +
                "NodeID= "+nodeId+
                "NetworkName= "+networkName+
                "Caller ID= "+callerId+
                "Caller Name= "+callerName+
                "Fault Reason = "+faultReason+
                "Fault Time = "+faultTimestamp+
                '}';
    }
}
