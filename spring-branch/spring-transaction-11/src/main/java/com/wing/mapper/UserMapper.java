package com.wing.mapper;

import com.wing.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author memory125
 */
public interface UserMapper {
    List<User> queryUsers();

    List<User> getAllUsers();

    int addUser(Map map);

    int deleteUser(int id);
}
