package com.UpdateBook.service;

import com.SearchBooks.entity.AllBookEntity;
import com.UpdateBook.dao.UpdateBookDao;

/**
 * @author dog-king
 * @create 2022/4/28
 */
public class UpDateBookService {
    UpdateBookDao updateBookDao = null;

    public void UpdateBookService(AllBookEntity editBookEntity) {
        updateBookDao = new UpdateBookDao();
        updateBookDao.UpdateBookDao(editBookEntity);
    }
}
