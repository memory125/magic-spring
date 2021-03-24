package com.wing.test;

import com.wing.mapper.UserMapper;
import com.wing.pojo.User;
import com.wing.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void testQueryAllUsers() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        // 关闭sql连接
        sqlSession.close();
    }
}
