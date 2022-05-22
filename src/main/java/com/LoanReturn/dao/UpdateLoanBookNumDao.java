package com.LoanReturn.dao;

import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dog-king
 * @create 2022/4/29
 */
public class UpdateLoanBookNumDao {
    public void UpDateLoanBookNum(int UpdateLoanNumBook,String BookId){
        JDBC jdbc = new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = jdbc.getJdbcConnecton();
            ps = conn.prepareStatement("UPDATE books SET loanNum=? WHERE BookId=?;");
            ps.setInt(1, UpdateLoanNumBook);
            ps.setString(2,BookId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
                jdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
