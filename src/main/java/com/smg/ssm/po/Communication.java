package com.smg.ssm.po;

import java.util.Date;

public class Communication {
    private Integer communicationId;

    private String communicationName;

    private String communicationAddress;

    private Date communicationStarttime;

    private Date communicationEndtime;

    private Integer communicationMan;

    private Integer communicationState;

    private String communicationReason;

    public Integer getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(Integer communicationId) {
        this.communicationId = communicationId;
    }

    public String getCommunicationName() {
        return communicationName;
    }

    public void setCommunicationName(String communicationName) {
        this.communicationName = communicationName == null ? null : communicationName.trim();
    }

    public String getCommunicationAddress() {
        return communicationAddress;
    }

    public void setCommunicationAddress(String communicationAddress) {
        this.communicationAddress = communicationAddress == null ? null : communicationAddress.trim();
    }

    public Date getCommunicationStarttime() {
        return communicationStarttime;
    }

    public void setCommunicationStarttime(Date communicationStarttime) {
        this.communicationStarttime = communicationStarttime;
    }

    public Date getCommunicationEndtime() {
        return communicationEndtime;
    }

    public void setCommunicationEndtime(Date communicationEndtime) {
        this.communicationEndtime = communicationEndtime;
    }

    public Integer getCommunicationMan() {
        return communicationMan;
    }

    public void setCommunicationMan(Integer communicationMan) {
        this.communicationMan = communicationMan;
    }

    public Integer getCommunicationState() {
        return communicationState;
    }

    public void setCommunicationState(Integer communicationState) {
        this.communicationState = communicationState;
    }

    public String getCommunicationReason() {
        return communicationReason;
    }

    public void setCommunicationReason(String communicationReason) {
        this.communicationReason = communicationReason == null ? null : communicationReason.trim();
    }
}