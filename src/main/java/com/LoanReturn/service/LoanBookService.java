package com.LoanReturn.service;

import com.LoanReturn.dao.LoanBookDao;
import com.LoanReturn.entity.LoanBookEntity;

/**
 * @author dog-king
 * @create 2022/4/29
 */
public class LoanBookService {
    LoanBookDao loanBookDao=null;
    public String LoanBookService(LoanBookEntity loanBookEntity){
        loanBookDao=new LoanBookDao();
       String message= loanBookDao.LoanBookDao(loanBookEntity);
       return message;
    }
}
