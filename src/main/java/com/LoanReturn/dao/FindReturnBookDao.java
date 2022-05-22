package com.LoanReturn.dao;

import com.LoanReturn.entity.LoanBookEntity;
import com.LoanReturn.entity.LoanRecordEntity;
import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dog-king
 * @create 2022/4/30
 */
public class FindReturnBookDao {
    public List<LoanRecordEntity> ReturnNookDao(int userId){
        List<LoanRecordEntity> list=new ArrayList<>();
        LoanBookEntity loanBookEntity=new LoanBookEntity();
        JDBC jdbc = new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        conn = jdbc.getJdbcConnecton();
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement("SELECT loan.LoanId,loan.BookId,books.BookName,loan.LoanDate,loan.LoanState FROM `loan`,books WHERE loan.BookId =books.BookId AND loan.LoanState=? AND loan.userId=? ORDER BY loan.LoanId ASC ;");
            ps.setString(1, loanBookEntity.getLoanState());
            ps.setInt(2,userId);
            rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(new LoanRecordEntity(rs.getInt("LoanId"),
                        rs.getString("bookId"),rs.getString("BookName"),
                        rs.getString("LoanDate"),rs.getString("LoanState")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                conn.close();
                ps.close();
                jdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return list;

    }
}
