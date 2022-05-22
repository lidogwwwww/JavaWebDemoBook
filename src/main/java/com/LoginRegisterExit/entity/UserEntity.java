package com.LoginRegisterExit.entity;

/**
 * @author dog-king
 * @create 2022/4/25
 */
public class UserEntity {
    private String UserName;
    private String Password;
    private String UserId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public UserEntity() {
    }

    public UserEntity(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
