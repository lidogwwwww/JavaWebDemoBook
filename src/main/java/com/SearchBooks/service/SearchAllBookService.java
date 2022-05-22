package com.SearchBooks.service;

import com.SearchBooks.Dao.SearchAllBookDao;
import com.SearchBooks.entity.AllBookEntity;

import java.util.List;

/**
 * @author dog-king
 * @create 2022/4/26
 */
public class SearchAllBookService {
     SearchAllBookDao searchAllBook=new SearchAllBookDao();
     public List<AllBookEntity> SearchAllBookService(){
         return searchAllBook.SearchAllBook();
     }

}
