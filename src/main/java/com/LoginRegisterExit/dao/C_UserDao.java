package com.LoginRegisterExit.dao;

import com.LoginRegisterExit.entity.C_UserEntity;

import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dog-king
 * @create 2022/4/29
 */
public class C_UserDao {
    public C_UserEntity C_UserDao(C_UserEntity c_userEntity){
        C_UserEntity result=null;
        JDBC jdbc=new JDBC();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=jdbc.getJdbcConnecton();
            ps=conn.prepareStatement("SELECT * FROM user WHERE userAccount=? AND userPassword=?;");
            ps.setString(1,c_userEntity.getC_userAccount());
            ps.setString(2,c_userEntity.getC_userPassword());
            rs=ps.executeQuery();
            if(rs.next())
            {
                result=new C_UserEntity();
                result.setC_userId(rs.getInt("userId"));
                result.setC_username(rs.getString("userName"));
                result.setC_userAccount(rs.getString("userAccount"));
                result.setC_userPassword(rs.getString("userPassword"));
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
