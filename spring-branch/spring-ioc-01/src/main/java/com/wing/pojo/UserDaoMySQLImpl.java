package com.wing.pojo;

/**
 * @author memory125
 */
public class UserDaoMySQLImpl implements UserDao{
    public void getUser() {
        System.out.println(this.getClass() + "========getUser");
    }
}
