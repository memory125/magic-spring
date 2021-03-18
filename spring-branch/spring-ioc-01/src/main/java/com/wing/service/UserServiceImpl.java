package com.wing.service;

import com.wing.pojo.UserDao;

/**
 * @author memory125
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 这里是重点，通过setUserDao接口可以动态创建不同的对象
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
