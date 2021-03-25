package com.wing.mapper;

import com.wing.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author memory125
 */
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    public List<User> queryUsers() {
        return getSqlSession().getMapper(UserMapper.class).queryUsers();
    }

    public List<User> getAllUsers() {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);

        Map map = new HashMap();
        map.put("id", 11);
        map.put("name", "Jerry");
        map.put("pwd", 999888);

        int result = mapper.addUser(map);
        if (result > 0) {
            System.out.println("Add user success!");
        }

        result =  mapper.deleteUser(11);
        if (result > 0) {
            System.out.println("Delete user success!");
        }

        return mapper.getAllUsers();

        //return getSqlSession().getMapper(UserMapper.class).getAllUsers();
    }

    public int addUser(Map map) {
        return getSqlSession().getMapper(UserMapper.class).addUser(map);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
