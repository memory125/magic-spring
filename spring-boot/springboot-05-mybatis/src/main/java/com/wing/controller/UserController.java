package com.wing.controller;

import com.wing.mapper.UserMapper;
import com.wing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author memory125
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 查询所有用户
    @RequestMapping("/queryAllUsers")
    public List<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }

    // 根据ID查询用户
    @RequestMapping("/queryUserById")
    public String queryUserById() {
        return userMapper.queryUserById(10).toString();
    }

    // 添加用户
    @RequestMapping("/addUser")
    public String addUser() {
        int res = userMapper.addUser(new User(11, "Tiffany", "666555"));
        if (res > 0) {
            return "addUser-Ok!";
        } else {
            return "addUser-Failed!";
        }

    }

    // 修改用户信息
    @RequestMapping("/updateUser")
    public String updateUser() {
        int res = userMapper.updateUser(new User(11, "Tiffany Franklin", "777888"));
        if (res > 0) {
            return "updateUser-Ok!";
        } else {
            return "updateUser-Failed!";
        }
    }

    // 删除用户
    @RequestMapping("/deleteUserById")
    public String deleteUserById() {
        int res = userMapper.deleteUserById(11);
        if (res > 0) {
            return "deleteUserById-Ok!";
        } else {
            return "deleteUserById-Failed!";
        }
    }
}
