package com.LoginRegisterExit.dao;

import com.LoginRegisterExit.entity.registerEntity;
import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author dog-king
 * @create 2022/5/1
 */
public class RegisterDao {
    public String registerDao(registerEntity registerEntity){
        String message=null;
        //查找用户名是否注册过
        DBUserNameDao dbUserNameDao=new DBUserNameDao();
        boolean ms=dbUserNameDao.FindUserNameDao(registerEntity.getUserName());
        if(!ms) {
            //查找数据库的新用户Id
            DBUserIdDao dbUserIdDao = new DBUserIdDao();
            int userId = dbUserIdDao.DBUserIdDao();

            JDBC jdbc = new JDBC();
            Connection conn = null;
            PreparedStatement ps = null;
            conn = jdbc.getJdbcConnecton();
            try {
                ps = conn.prepareStatement("INSERT INTO user VALUES(?,?,?,?);");
                ps.setInt(1, userId);
                ps.setString(2, registerEntity.getUserName());
                ps.setString(3, registerEntity.getAccount());
                ps.setString(4, registerEntity.getPassword());
                ps.executeUpdate();
                message = "success";
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                jdbc.close();
            }
        }
        return message;
    }
}
