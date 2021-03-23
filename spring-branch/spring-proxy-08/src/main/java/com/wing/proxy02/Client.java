package com.wing.proxy02;

/**
 * @author memory125
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserProxy userProxy = new UserProxy();
        userProxy.setUserService(userService);
        userProxy.addUser();
        userProxy.deleteUser();
        userProxy.updateUser();
        userProxy.queryUser();
    }
}
