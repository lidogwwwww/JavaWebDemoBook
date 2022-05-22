package com.LoginRegisterExit.dao;

import com.LoginRegisterExit.entity.UserEntity;
import com.jdbcConnection.JDBC;

import java.sql.*;

/**
 * @author dog-king
 * @create 2022/4/25
 */
public class UserDao {
    public UserEntity login(UserEntity userEntity){
        JDBC jdbc=new JDBC();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        UserEntity result=null;
        try {
            conn=jdbc.getJdbcConnecton();
            ps=conn.prepareStatement("SELECT * FROM users WHERE UserName=? AND Password=?;");
            ps.setString(1,userEntity.getUserName());
            ps.setString(2,userEntity.getPassword());
            rs=ps.executeQuery();
            if(rs.next())
            {
              result=new UserEntity();
              result.setUserId(rs.getString("UserId"));
              result.setUserName(rs.getString("UserName"));
              result.setPassword(rs.getString("Password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)
                {
                        conn.close();
                }
                if(ps!=null)
                {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            jdbc.close();
        }
        return result;
    }
}
