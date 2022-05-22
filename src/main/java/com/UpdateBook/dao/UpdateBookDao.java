package com.UpdateBook.dao;

import com.SearchBooks.entity.AllBookEntity;
import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author dog-king
 * @create 2022/4/28
 */
public class UpdateBookDao {
    public void  UpdateBookDao(AllBookEntity editBookEntity){
        JDBC jdbc=new JDBC();
        Connection conn=null;
        PreparedStatement ps=null;
        conn=jdbc.getJdbcConnecton();
        try {
            ps=conn.prepareStatement("UPDATE books SET BookType=?,BookName=?,BookAuthor=?,BookNum=? WHERE BookId=?;");
            ps.setString(1,editBookEntity.getBookType());
            ps.setString(2,editBookEntity.getBookName());
            ps.setString(3,editBookEntity.getBookAuthor());
            ps.setString(4, String.valueOf(editBookEntity.getBookNum()));
            ps.setString(5,editBookEntity.getBookId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
