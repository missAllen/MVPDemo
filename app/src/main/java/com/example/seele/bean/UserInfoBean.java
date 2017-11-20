package com.example.seele.bean;

/**
 * Created by SEELE on 2017/11/20.
 */

public class UserInfoBean {
    private long userId;
    private String userName;
    private String userPwd;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
