package com.LoginRegisterExit.service;

import com.LoginRegisterExit.dao.UserDao;
import com.LoginRegisterExit.entity.UserEntity;

/**
 * @author dog-king
 * @create 2022/4/25
 */
public class UserService {
    UserDao userDao = new UserDao();

    public UserEntity login(UserEntity userEntity) {
        return userDao.login(userEntity);
    }
}
