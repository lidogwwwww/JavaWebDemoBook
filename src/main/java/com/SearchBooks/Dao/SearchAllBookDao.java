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
 * @create 2022/4/26
 */
public class SearchAllBookDao {
    public List<AllBookEntity> SearchAllBook(){
        List<AllBookEntity> list=new ArrayList<>();
        JDBC jdbc=new JDBC();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=jdbc.getJdbcConnecton();
            ps=conn.prepareStatement("Select * FROM books ORDER by `BookId`;");
             rs=ps.executeQuery();
            while(rs.next()){
                list.add(new AllBookEntity(rs.getString("BookId"),rs.getString("BookType"),rs.getString("BookName"),rs.getString("BookAuthor"),rs.getInt("BookNum"), rs.getInt("LoanNum")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null||ps!=null||conn!=null) {
                    rs.close();
                    ps.close();
                    jdbc.close();
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return list;
    }
}
