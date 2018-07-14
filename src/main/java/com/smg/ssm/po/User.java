package com.smg.ssm.po;

public class User {
    private Integer userId;

    private String userPw;

    private String userIdnumber;

    private String userPhonenumber;

    private String userName;

    private Integer userType;

    private String userAddress;

    private Integer userIsadmin;

    private Integer userState;

    private String userReason;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw == null ? null : userPw.trim();
    }

    public String getUserIdnumber() {
        return userIdnumber;
    }

    public void setUserIdnumber(String userIdnumber) {
        this.userIdnumber = userIdnumber == null ? null : userIdnumber.trim();
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber == null ? null : userPhonenumber.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public Integer getUserIsadmin() {
        return userIsadmin;
    }

    public void setUserIsadmin(Integer userIsadmin) {
        this.userIsadmin = userIsadmin;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUserReason() {
        return userReason;
    }

    public void setUserReason(String userReason) {
        this.userReason = userReason == null ? null : userReason.trim();
    }
}