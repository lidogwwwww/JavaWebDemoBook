package com.LoginRegisterExit.entity;

/**
 * @author dog-king
 * @create 2022/5/1
 */
public class registerEntity {
    private int userId=0;
    private String userName=null;
    private String account=null;
    private String password=null;

    public registerEntity() {
    }

    public registerEntity(String userName, String account, String password) {
        this.userName = userName;
        this.account = account;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
