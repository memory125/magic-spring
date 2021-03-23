package com.wing.proxy02;

/**
 * @author memory125
 */
public class UserProxy implements UserService {
    private UserServiceImpl userService;

    public UserProxy() {
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void addUser() {
        logInfo("addUser");
        userService.addUser();
    }

    public void deleteUser() {
        logInfo("deleteUser");
        userService.deleteUser();
    }

    public void updateUser() {
        logInfo("updateUser");
        userService.updateUser();
    }

    public void queryUser() {
        logInfo("queryUser");
        userService.queryUser();
    }

    public void logInfo(String msg) {
        System.out.println("The program is invoking " + msg + " method!!!");
    }

}
