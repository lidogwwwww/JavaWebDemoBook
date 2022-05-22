package com.LoanReturn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dog-king
 * @create 2022/4/29
 */
public class LoanBookEntity {
    private String LoanBookId;
    private String LoanUserName;
    private Date date = null;
    private int LoanUserId;
    private static String LoanState = "borrowing";
    private static String LoanEndState = "returned ";


    public LoanBookEntity() {
    }

    public LoanBookEntity(String loanBookId, String loanUserName, Date date, int loanUserId) {
        LoanBookId = loanBookId;
        LoanUserName = loanUserName;
        this.date = date;
        LoanUserId = loanUserId;
    }

    public String getLoanBookId() {
        return LoanBookId;
    }

    public int getLoanUserId() {
        return LoanUserId;
    }

    public void setLoanUserId(int loanUserId) {
        LoanUserId = loanUserId;
    }

    public String getLoanUserName() {
        return LoanUserName;
    }

    public String getDate() {//获取当前时间
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String date=ft.format(this.date);
        return date;
    }

    public String getLoanState() {
        return LoanState;
    }

    public static String getLoanEndState() {
        return LoanEndState;
    }

    public void setLoanBookId(String loanBookId) {
        LoanBookId = loanBookId;
    }

    public void setLoanUserName(String loanUserName) {
        LoanUserName = loanUserName;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
