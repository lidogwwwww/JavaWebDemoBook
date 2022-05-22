package com.DeleteBook.Dao;

import com.SearchBooks.entity.AllBookEntity;
import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author dog-king
 * @create 2022/4/27
 */
public class DeleteBookDao {
    public void deleteBookDao(AllBookEntity deleteBookEntity) {
        Connection conn = null;
        PreparedStatement ps = null;
        JDBC jdbc = new JDBC();
        try {
            conn = jdbc.getJdbcConnecton();
            ps = conn.prepareStatement("delete from books WHERE BookName=? AND BookAuthor=? ;");
            ps.setString(1, deleteBookEntity.getBookName());
            ps.setString(2, deleteBookEntity.getBookAuthor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                jdbc.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
