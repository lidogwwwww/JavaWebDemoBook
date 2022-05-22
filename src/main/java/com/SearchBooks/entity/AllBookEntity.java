package com.SearchBooks.entity;

/**
 * @author dog-king
 * @create 2022/4/25
 */
public class AllBookEntity {
   private String BookId;
    private String BookType;
    private String BookName;
    private String BookAuthor;
    private int BookNum;
    private int LoanNum;

    public AllBookEntity() {
    }

    public AllBookEntity(String bookId, String bookType, String bookName, String bookAuthor, int bookNum, int loanNum) {
        BookId = bookId;
        BookType = bookType;
        BookName = bookName;
        BookAuthor = bookAuthor;
        BookNum = bookNum;
        LoanNum = loanNum;
    }

    public AllBookEntity(String bookId, String bookType, String bookName, String bookAuthor, int bookNum) {
        BookId = bookId;
        BookType = bookType;
        BookName = bookName;
        BookAuthor = bookAuthor;
        BookNum = bookNum;
    }

    public int getLoanNum() {
        return LoanNum;
    }

    public void setLoanNum(int loanNum) {
        LoanNum = loanNum;
    }

    public AllBookEntity(String bookId, String bookType, String bookName, String bookAuthor, String bookNum) {
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookType() {
        return BookType;
    }

    public void setBookType(String bookType) {
        BookType = bookType;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public int getBookNum() {
        return BookNum;
    }

    public void setBookNum(int bookNum) {
        BookNum = bookNum;
    }

    @Override
    public String toString() {
        return "AllBookEntity{" +
                "BookId='" + BookId + '\'' +
                ", BookType='" + BookType + '\'' +
                ", BookName='" + BookName + '\'' +
                ", BookAuthor='" + BookAuthor + '\'' +
                ", BookNum=" + BookNum +
                '}';
    }
}
