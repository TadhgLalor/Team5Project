package com.ericsson.kafkaconsumer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Call;

import java.time.LocalDateTime;



@Entity
@Table(name="call_faults_db")
public class CallFault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private int nodeId;
    private int networkId;
    private String networkName;
    private int callerId;
    private String callerName;
    @Enumerated(EnumType.STRING)
    private FaultReason faultReason;

    @JsonDeserialize (using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime faultTimestamp;

    CallFault(){

    }

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
