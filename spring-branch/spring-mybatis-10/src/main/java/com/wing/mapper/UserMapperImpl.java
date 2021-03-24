package com.wing.mapper;

import com.wing.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author memory125
 */
public class UserMapperImpl implements UserMapper {

    // 之前的操作都通过sqlSession来执行，现在都使用SqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> getAllUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getAllUsers();
    }
}
