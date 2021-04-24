package com.wing.service;

import com.wing.pojo.User;

import java.util.List;

/**
 * @author memory125
 */
public interface UserService {
    // 查询所有用户
    List<User> queryAllUsers();

    // 根据ID查询用户
    User queryUserById(int id);

    // 添加用户
    int addUser(User user);

    // 修改用户信息
    int updateUser(User user);

    // 删除用户
    int deleteUserById(int id);

    // 根据用户姓名车查询用户
    User queryUserByName(String name);
}
