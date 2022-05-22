package com.SearchBooks.Dao;

import com.SearchBooks.entity.AllBookEntity;
import com.jdbcConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dog-king
 * @create 2022/4/27
 */
public class SearchBookDao {
    public List<AllBookEntity> SearchBook(  AllBookEntity allBookEntity){
        List<AllBookEntity> list=new ArrayList();
        JDBC jdbc=new JDBC();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet re=null;
        try {
            conn=jdbc.getJdbcConnecton();
            ps=conn.prepareStatement("SELECT * FROM `books`WHERE BookName=? UNION SELECT * FROM books WHERE BookAuthor=?UNION SELECT *FROM books WHERE BookType=?;");
            ps.setString(1,allBookEntity.getBookName());
            ps.setString(2,allBookEntity.getBookAuthor());
            ps.setString(3,allBookEntity.getBookType());
            re=ps.executeQuery();
            while (re.next())
            {
                list.add(new AllBookEntity(re.getString("BookId"),re.getString("BookType"),re.getString("BookName"),re.getString("BookAuthor"),re.getInt("BookNum")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                re.close();
                ps.close();
                jdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
