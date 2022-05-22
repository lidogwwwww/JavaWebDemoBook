package com.SearchBooks.service;

import com.SearchBooks.Dao.SearchBookDao;
import com.SearchBooks.entity.AllBookEntity;

import java.util.List;

/**
 * @author dog-king
 * @create 2022/4/27
 */
public class SearchBookService {
    SearchBookDao searchBookDao=null;
    public List<AllBookEntity> SearchBookService( AllBookEntity allBookEntity){
        searchBookDao=new SearchBookDao();
        return searchBookDao.SearchBook(allBookEntity);
    }
}
