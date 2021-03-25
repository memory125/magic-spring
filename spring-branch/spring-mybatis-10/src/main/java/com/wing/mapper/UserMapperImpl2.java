package com.wing.mapper;

import com.wing.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author memory125
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {

    public List<User> getAllUsers() {
        return getSqlSession().getMapper(UserMapper.class).getAllUsers();
    }
}
