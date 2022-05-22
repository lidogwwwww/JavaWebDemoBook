package com.LoanReturn.service;

import com.LoanReturn.dao.ReturnBookDao;

/**
 * @author dog-king
 * @create 2022/4/30
 */
public class ReturnBookService {
    ReturnBookDao returnBookDao =null;
    public boolean ReturnBookService(int loanId){
        returnBookDao=new ReturnBookDao();
        return returnBookDao.ReturnBookDao(loanId);
    }
}
