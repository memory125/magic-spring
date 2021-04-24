package com.wing.mapper;

import com.wing.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author memory125
 */
// @Mapper：表示这是一个Mybatis的mapper类 - Dao
@Mapper
@Repository
public interface UserMapper {
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
