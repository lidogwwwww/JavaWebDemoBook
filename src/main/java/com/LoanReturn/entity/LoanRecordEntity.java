package com.LoanReturn.entity;

/**
 * @author dog-king
 * @create 2022/4/30
 */
public class LoanRecordEntity {
    private int LoanId=0;
    private String BookId=null;
    private String BookName=null;
    private int UserId=0;
    private String UserName=null;
    private String LoanDate=null;
    private String LoanState=null;

    public LoanRecordEntity(int loanId, String bookId, String bookName, String loanDate, String loanState) {
        LoanId = loanId;
        BookId = bookId;
        BookName = bookName;
        LoanDate = loanDate;
        LoanState = loanState;
    }

    public LoanRecordEntity(int loanId, String bookId, String bookName, int userId, String userName, String loanDate, String loanState) {
        LoanId = loanId;
        BookId = bookId;
        BookName = bookName;
        UserId = userId;
        UserName = userName;
        LoanDate = loanDate;
        LoanState = loanState;
    }

    public int getLoanId() {
        return LoanId;
    }

    public void setLoanId(int loanId) {
        LoanId = loanId;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getLoanDate() {
        return LoanDate;
    }

    public void setLoanDate(String loanDate) {
        LoanDate = loanDate;
    }

    public String getLoanState() {
        return LoanState;
    }

    public void setLoanState(String loanState) {
        LoanState = loanState;
    }

    @Override
    public String toString() {
        return "LoanRecordEntity{" +
                "LoanId=" + LoanId +
                ", BookId='" + BookId + '\'' +
                ", BookName='" + BookName + '\'' +
                ", UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", LoanDate='" + LoanDate + '\'' +
                ", LoanState='" + LoanState + '\'' +
                '}';
    }
}
