package com.ericsson.kafkaproducer;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;


public class CallFault {
    private int nodeId;
    private int networkId;
    private String networkName;
    private int callerId;
    private String callerName;
    private FaultReason faultReason;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime faultTimestamp;

    public CallFault(int nodeId, int networkId, String networkName,int callerId, String callerName,
                     FaultReason faultReason) {
        this.nodeId = nodeId;
        this.networkId = networkId;
        this.networkName=networkName;
        this.callerId=callerId;
        this.callerName=callerName;
        this.faultReason=faultReason;
        faultTimestamp=LocalDateTime.now();
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

    public LocalDateTime getFaultTimestamp() {
        return faultTimestamp;
    }
}
