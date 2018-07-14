package com.smg.ssm.po;

import java.util.Date;

public class Award {
    private Integer awardId;

    private String awardName;

    private Date awardTime;

    private Integer awardType;

    private Integer awardAwarder;

    private Integer awardState;

    private String awardReason;

    public Integer getAwardId() {
        return awardId;
    }

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName == null ? null : awardName.trim();
    }

    public Date getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(Date awardTime) {
        this.awardTime = awardTime;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public Integer getAwardAwarder() {
        return awardAwarder;
    }

    public void setAwardAwarder(Integer awardAwarder) {
        this.awardAwarder = awardAwarder;
    }

    public Integer getAwardState() {
        return awardState;
    }

    public void setAwardState(Integer awardState) {
        this.awardState = awardState;
    }

    public String getAwardReason() {
        return awardReason;
    }

    public void setAwardReason(String awardReason) {
        this.awardReason = awardReason == null ? null : awardReason.trim();
    }
}