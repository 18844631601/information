package com.smg.ssm.po;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Patent {
    private String patentId;

    private String patentName;
    
    @JSONField(format = "yyyy-MM-dd")
    private Date patentApplytime;
    
    @JSONField(format = "yyyy-MM-dd")
    private Date patentGettime;

    private Integer patentPatentee;

    private Integer patentState;

    private String patentReason;

    public String getPatentId() {
        return patentId;
    }

    public void setPatentId(String patentId) {
        this.patentId = patentId == null ? null : patentId.trim();
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName == null ? null : patentName.trim();
    }

    public Date getPatentApplytime() {
        return patentApplytime;
    }

    public void setPatentApplytime(Date patentApplytime) {
        this.patentApplytime = patentApplytime;
    }

    public Date getPatentGettime() {
        return patentGettime;
    }

    public void setPatentGettime(Date patentGettime) {
        this.patentGettime = patentGettime;
    }

    public Integer getPatentPatentee() {
        return patentPatentee;
    }

    public void setPatentPatentee(Integer patentPatentee) {
        this.patentPatentee = patentPatentee;
    }

    public Integer getPatentState() {
        return patentState;
    }

    public void setPatentState(Integer patentState) {
        this.patentState = patentState;
    }

    public String getPatentReason() {
        return patentReason;
    }

    public void setPatentReason(String patentReason) {
        this.patentReason = patentReason == null ? null : patentReason.trim();
    }
}