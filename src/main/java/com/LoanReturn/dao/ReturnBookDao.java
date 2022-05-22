package com.LoanReturn.dao;

import com.LoanReturn.entity.LoanBookEntity;
import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author dog-king
 * @create 2022/4/30
 */
public class ReturnBookDao {
    public boolean ReturnBookDao(int loanId){
        LoanBookEntity loanBookEntity=new LoanBookEntity();
        JDBC jdbc=new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        conn = jdbc.getJdbcConnecton();
        try {
            ps=conn.prepareStatement("UPDATE loan set LoanState=? WHERE LoanId=?");
            ps.setString(1, loanBookEntity.getLoanEndState());
            ps.setInt(2,loanId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
                jdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
