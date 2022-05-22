package com.LoginRegisterExit.service;

import com.LoginRegisterExit.dao.RegisterDao;
import com.LoginRegisterExit.entity.registerEntity;

/**
 * @author dog-king
 * @create 2022/5/1
 */
public class RegisterService {
    RegisterDao registerDao=null;
    public String registerService(registerEntity RegisterEntity){
        registerDao=new RegisterDao();
        return registerDao.registerDao(RegisterEntity);
    }
}
