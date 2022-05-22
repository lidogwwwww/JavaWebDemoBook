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
public class DBUserIdDao {
    public synchronized int DBUserIdDao(){
        int lastUserId=0;
        JDBC jdbc = new JDBC();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        conn = jdbc.getJdbcConnecton();
        try {
            ps = conn.prepareStatement("SELECT userId FROM user ORDER BY userId DESC LIMIT 1;");
            rs=ps.executeQuery();
            while (rs.next())
            {
                lastUserId=rs.getInt("userId");
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
        return ++lastUserId;
    }
}
