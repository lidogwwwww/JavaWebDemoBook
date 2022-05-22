package com.DeleteBook.service;

import com.DeleteBook.Dao.DeleteBookDao;
import com.SearchBooks.entity.AllBookEntity;

/**
 * @author dog-king
 * @create 2022/4/27
 */
public class DeleteBookService {
    DeleteBookDao deleteBookDao=null;
    public void DeleteBookService(AllBookEntity deleteBookEntity) {
        deleteBookDao = new DeleteBookDao();
        deleteBookDao.deleteBookDao(deleteBookEntity);
    }

    }
