package com.LoginRegisterExit.entity;

/**
 * @author dog-king
 * @create 2022/4/29
 */
public class C_UserEntity {
    private String C_username;
    private String C_userAccount;
    private String C_userPassword;
    private int C_userId;

    public C_UserEntity() {
    }

    public C_UserEntity(String c_userAccount, String c_userPassword) {
        C_userAccount = c_userAccount;
        C_userPassword = c_userPassword;
    }

    public int getC_userId() {
        return C_userId;
    }

    public void setC_userId(int c_userId) {
        C_userId = c_userId;
    }

    public String getC_username() {
        return C_username;
    }

    public void setC_username(String c_username) {
        C_username = c_username;
    }

    public String getC_userAccount() {
        return C_userAccount;
    }

    public void setC_userAccount(String c_userAccount) {
        C_userAccount = c_userAccount;
    }

    public String getC_userPassword() {
        return C_userPassword;
    }

    public void setC_userPassword(String c_userPassword) {
        C_userPassword = c_userPassword;
    }
}
