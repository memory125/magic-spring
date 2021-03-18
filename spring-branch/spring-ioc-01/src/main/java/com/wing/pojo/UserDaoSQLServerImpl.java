package com.wing.pojo;

/**
 * @author memory125
 */
public class UserDaoSQLServerImpl implements UserDao{
    public void getUser() {
        System.out.println(this.getClass() + "========getUser");
    }
}
