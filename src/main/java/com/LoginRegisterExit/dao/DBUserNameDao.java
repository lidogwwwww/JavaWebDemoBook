package com.LoginRegisterExit.dao;

import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dog-king
 * @create 2022/5/1
 */
public class DBUserNameDao {
    public boolean FindUserNameDao(String userName){
        boolean message=false;
        JDBC jdbc = new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbc.getJdbcConnecton();
            ps = conn.prepareStatement("SELECT userName FROM user WHERE userName=?;");
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                message=true;
                return message;
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

        return  message;

    }
}
