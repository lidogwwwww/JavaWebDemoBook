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
//获取指定书目的借书的数量
public class LoanBookNumDao {
    public int LoanBookNumDao(String LoanBookId) {
        JDBC jdbc = new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = jdbc.getJdbcConnecton();
            ps = conn.prepareStatement("SELECT LoanNum FROM books WHERE BookId=?;");
            ps.setString(1, LoanBookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = Integer.parseInt(rs.getString("LoanNum"));
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

