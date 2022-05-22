package com.LoginRegisterExit.service;

import com.LoginRegisterExit.dao.C_UserDao;
import com.LoginRegisterExit.entity.C_UserEntity;



/**
 * @author dog-king
 * @create 2022/4/29
 */
public class C_UserService {
    C_UserDao c_userDao = null;

    public C_UserEntity C_userService(C_UserEntity c_userEntity) {
        c_userDao = new C_UserDao();
        return c_userDao.C_UserDao(c_userEntity);
    }
}
