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
//获取数据库指定图书数量
public class BookNumDao {
    public int BookNum(String BookId){
        JDBC jdbc = new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = jdbc.getJdbcConnecton();
            ps = conn.prepareStatement("SELECT BookNum FROM books WHERE BookId=?;");
            ps.setString(1, BookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = Integer.parseInt(rs.getString("BookNum"));
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
