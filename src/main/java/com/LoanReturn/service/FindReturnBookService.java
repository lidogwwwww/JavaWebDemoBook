package com.LoanReturn.service;

import com.LoanReturn.dao.FindReturnBookDao;
import com.LoanReturn.entity.LoanRecordEntity;

import java.util.List;

/**
 * @author dog-king
 * @create 2022/4/30
 */
public class FindReturnBookService {
    FindReturnBookDao findReturnBookDao =null;
            public List<LoanRecordEntity> ReturnBookService(int userId){
                findReturnBookDao =new FindReturnBookDao();
               return findReturnBookDao.ReturnNookDao(userId);
            }
}
