package com.smg.ssm.po;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Paper {
    private String paperId;

    private String paperName;

    private Integer paperType;

    private String paperContent;

    private String paperKeywords;

    private Integer paperInstructor;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date paperPublishtime;

    private Integer paperUtterer;

    private Integer paperState;

    private String paperReason;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    public String getPaperContent() {
        return paperContent;
    }

    public void setPaperContent(String paperContent) {
        this.paperContent = paperContent == null ? null : paperContent.trim();
    }

    public String getPaperKeywords() {
        return paperKeywords;
    }

    public void setPaperKeywords(String paperKeywords) {
        this.paperKeywords = paperKeywords == null ? null : paperKeywords.trim();
    }

    public Integer getPaperInstructor() {
        return paperInstructor;
    }

    public void setPaperInstructor(Integer paperInstructor) {
        this.paperInstructor = paperInstructor;
    }

    public Date getPaperPublishtime() {
        return paperPublishtime;
    }

    public void setPaperPublishtime(Date paperPublishtime) {
        this.paperPublishtime = paperPublishtime;
    }

    public Integer getPaperUtterer() {
        return paperUtterer;
    }

    public void setPaperUtterer(Integer paperUtterer) {
        this.paperUtterer = paperUtterer;
    }

    public Integer getPaperState() {
        return paperState;
    }

    public void setPaperState(Integer paperState) {
        this.paperState = paperState;
    }

    public String getPaperReason() {
        return paperReason;
    }

    public void setPaperReason(String paperReason) {
        this.paperReason = paperReason == null ? null : paperReason.trim();
    }
}