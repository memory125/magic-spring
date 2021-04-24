package com.wing.controller;

import com.wing.pojo.User;
import com.wing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author memory125
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 查询所有用户
    @RequestMapping("/queryAllUsers")
    public List<User> queryAllUsers() {
        return userService.queryAllUsers();
    }

    // 根据ID查询用户
    @RequestMapping("/queryUserById")
    public User queryUserById() {
        return userService.queryUserById(11);
    }

    // 添加用户
    @RequestMapping("/addUser")
    public String addUser() {
        int res = userService.addUser(new User(11, "Tiffany", "666555", "none"));
        if (res > 0) {
            return "addUser-Ok!";
        } else {
            return "addUser-Failed!";
        }

    }

    // 修改用户信息
    @RequestMapping("/updateUser")
    public String updateUser() {
        int res = userService.updateUser(new User(11, "Tiffany Franklin", "777888","user:add"));
        if (res > 0) {
            return "updateUser-Ok!";
        } else {
            return "updateUser-Failed!";
        }
    }

    // 删除用户
    @RequestMapping("/deleteUserById")
    public String deleteUserById() {
        int res = userService.deleteUserById(11);
        if (res > 0) {
            return "deleteUserById-Ok!";
        } else {
            return "deleteUserById-Failed!";
        }
    }

    // 删除用户
    @RequestMapping("/queryUserByName/{name}")
    public String queryUserByName(@PathVariable("name") String name) {
        User user = userService.queryUserByName(name);
        return user.toString();
    }
}
