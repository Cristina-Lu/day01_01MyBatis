package com.mySQLClasses.domain;

import java.io.InputStream;
import java.util.Date;
import java.io.Serializable;

public class User implements Serializable {
    private String userName;//用户姓名
    private String userId;//用户唯一标志
    private String userMobile;//用户手机号
    private String accountId;//用户账户ＩＤ
    private boolean userStatues;//用户状态
    private Date accessTime;//入网时间

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean getUserStatues() {
        return userStatues;
    }

    public void setUserStatues(boolean userStatues) {
        this.userStatues = userStatues;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", accountId='" + accountId + '\'' +
                ", status='" + userStatues + '\'' +
                ", accessTime='" + accessTime + '\'' +
                '}';
    }




}
