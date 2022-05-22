package com.LoanReturn.dao;

import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dog-king
 * @create 2022/4/30
 */
public class UserLoanedBookRecordDao {
    public boolean UserLoanedBookRecordDao(int userId,String BookId){
        JDBC jdbc = new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String State=null;
        try {
            conn = jdbc.getJdbcConnecton();
            ps = conn.prepareStatement("SELECT LoanState FROM loan WHERE userId=? AND BookId=?;");
            ps.setInt(1, userId);
            ps.setString(2,BookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                State=rs.getString("LoanState");
                if(State.equals("borrowing")){
                    result=true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
                jdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
