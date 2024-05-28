package dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="call_faults_db")
public class CallFault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    private Integer nodeId;
    private Integer networkId;

    private String networkName;
    private Integer callerId;
    private String callerName;

    @Enumerated(EnumType.STRING)
    private FaultReason faultReason;

    private LocalDateTime faultTimestamp;

 /*   @Column(name = "nodeId")
    private Integer nodeId;

    @Column(name = "networkId")
    private Integer networkId;

    @Column(name = "networkName")
    private String networkName;

    @Column(name = "callerId")
    private Integer callerId;

    @Column(name = "callerName")
    private String callerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "faultReason")
    private FaultReason faultReason;

    @Column(name = "faultTimestamp")
    private LocalDateTime faultTimestamp;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Integer networkId) {
        this.networkId = networkId;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public Integer getCallerId() {
        return callerId;
    }

    public void setCallerId(Integer callerId) {
        this.callerId = callerId;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public FaultReason getFaultReason() {
        return faultReason;
    }

    public void setFaultReason(FaultReason faultReason) {
        this.faultReason = faultReason;
    }

    public LocalDateTime getFaultTimestamp() {
        return faultTimestamp;
    }

    public void setFaultTimestamp(LocalDateTime faultTimestamp) {
        this.faultTimestamp = faultTimestamp;
    }
}
