package com.wing.proxy04;

/**
 * @author memory125
 */
public class UserClient {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ProxyInvocationHanlder proxyInvocationHanlder = new ProxyInvocationHanlder();
        proxyInvocationHanlder.setTarget(userService);
        UserService proxy = (UserService) proxyInvocationHanlder.getProxy();
        proxy.queryUser();
        proxy.updateUser();
        proxy.deleteUser();
        proxy.addUser();
    }
}
