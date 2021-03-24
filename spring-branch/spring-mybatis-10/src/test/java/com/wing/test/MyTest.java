package com.wing.test;

import com.wing.mapper.UserMapper;
import com.wing.pojo.User;
import com.wing.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void testQueryAllUsers1() {
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

    @Test
    public void testQueryAllUsers2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
