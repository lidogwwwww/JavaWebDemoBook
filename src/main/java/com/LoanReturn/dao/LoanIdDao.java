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
public class LoanIdDao {
    public synchronized int LoanIdDao(){
        int lastLoanId=0;
        JDBC jdbc = new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        conn = jdbc.getJdbcConnecton();
        try {
            ps = conn.prepareStatement("SELECT LoanId FROM loan ORDER BY LoanId DESC LIMIT 1;");
            rs=ps.executeQuery();
            while (rs.next())
            {
                lastLoanId=rs.getInt("LoanId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            jdbc.close();
        }
        return ++lastLoanId;
    }
}
