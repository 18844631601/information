package com.smg.ssm.po;

import java.util.Date;

public class Project {
    private Integer projectId;

    private String projectName;

    private Date projectStarttime;

    private Date projectEndtime;

    private Integer projectLeader;

    private Integer projectState;

    private String projectReason;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Date getProjectStarttime() {
        return projectStarttime;
    }

    public void setProjectStarttime(Date projectStarttime) {
        this.projectStarttime = projectStarttime;
    }

    public Date getProjectEndtime() {
        return projectEndtime;
    }

    public void setProjectEndtime(Date projectEndtime) {
        this.projectEndtime = projectEndtime;
    }

    public Integer getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(Integer projectLeader) {
        this.projectLeader = projectLeader;
    }

    public Integer getProjectState() {
        return projectState;
    }

    public void setProjectState(Integer projectState) {
        this.projectState = projectState;
    }

    public String getProjectReason() {
        return projectReason;
    }

    public void setProjectReason(String projectReason) {
        this.projectReason = projectReason == null ? null : projectReason.trim();
    }
}