package com.LoanReturn.dao;

import com.LoanReturn.entity.LoanBookEntity;
import com.jdbcConnection.JDBC;

import java.sql.*;

/**
 * @author dog-king
 * @create 2022/4/29
 */
//对借阅图书进行数据库处理
public class LoanBookDao {
    public synchronized String LoanBookDao(LoanBookEntity loanBookEntity) {
        //查看用户是否借阅过此图书
        UserLoanedBookRecordDao userLoanedBookRecordDao = new UserLoanedBookRecordDao();
        boolean Y_N = userLoanedBookRecordDao.UserLoanedBookRecordDao(loanBookEntity.getLoanUserId(), loanBookEntity.getLoanBookId());
        if (Y_N) {
            return "false";
        } else {
            LoanBookNumDao loanBookNumDao = new LoanBookNumDao();
            //得到数据库此已经借阅图书的数量
            int loanBookNum = loanBookNumDao.LoanBookNumDao(loanBookEntity.getLoanBookId());

            BookNumDao bookNumDao = new BookNumDao();
            //得到数据库的图书库存
            int BookNum = bookNumDao.BookNum(loanBookEntity.getLoanBookId());
            //有库存
            if (BookNum > loanBookNum) {
                //得到需要传输到数据库借阅订单号
                int bookLoanId = 0;
                LoanIdDao loanIdDao = new LoanIdDao();
                bookLoanId = loanIdDao.LoanIdDao();

                JDBC jdbc = new JDBC();
                Connection conn = null;
                PreparedStatement ps = null;
                conn = jdbc.getJdbcConnecton();
                try {
                    ps = conn.prepareStatement("INSERT INTO loan VALUES(?,?,?,?,?,?);");
                    ps.setInt(1, bookLoanId);
                    ps.setString(2, loanBookEntity.getLoanBookId());
                    ps.setInt(3, loanBookEntity.getLoanUserId());
                    ps.setString(4, loanBookEntity.getLoanUserName());
                    ps.setString(5, loanBookEntity.getDate());
                    ps.setString(6, loanBookEntity.getLoanState());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        ps.close();
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    jdbc.close();
                }
                //每次借阅一本书,更新数据库已借阅的数量
                UpdateLoanBookNumDao updateLoanBookNumDao = new UpdateLoanBookNumDao();
                updateLoanBookNumDao.UpDateLoanBookNum(++loanBookNum, loanBookEntity.getLoanBookId());
                return "success";
            }
        }
        return "false";
    }
}
