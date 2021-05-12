package com.wing.service;

import com.wing.pojo.User;


public interface UserService {
    /**
     * 创建对象
     */
    User saveUser(User user);

    /**
     * 根据用户名查询对象
     * @return
     */
    User queryUserByName(String name);

    /**
     * 更新对象
     */
    void updateUser(User user);

    /**
     * 删除对象
     * @param id
     */
    void deleteUserById(int id);
}
