package com.LoanReturn.service;

import com.LoanReturn.dao.HistoryRecordDao;
import com.LoanReturn.entity.LoanRecordEntity;

import java.util.List;

/**
 * @author dog-king
 * @create 2022/4/30
 */
public class HistoryRecordService {
    HistoryRecordDao historyRecordDao=null;
    public List<LoanRecordEntity> HistoryRecordService(int userId){
        historyRecordDao=new HistoryRecordDao();
        return historyRecordDao.HistoryRecordDao(userId);
    }
}
