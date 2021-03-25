package com.wing.test;

import com.wing.mapper.UserMapper;
import com.wing.pojo.User;
import com.wing.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void testQueryAllUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.queryUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testAddUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        Map map = new HashMap();
        map.put("id", 12);
        map.put("name", "Jerry");
        map.put("pwd", 999888);
        int result = userMapper.addUser(map);
        if (result > 0) {
            System.out.println("Add user success!");
        }
    }

    @Test
    public void testDeleteUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        int result = userMapper.deleteUser(11);
        if (result > 0) {
            System.out.println("Delete user success!");
        }
    }

    /*
        下面的代码测试，添加用户记录会提交到数据库，原因是每次操作都获取了不同的SqlSession，分别是：
        addUser操作所使用SqlSession
        deleteUser操作所使用SqlSession
        getAllUsers操作所使用SqlSession
        这三个SqlSession在内存中代表着不同的对象
     */
    @Test
    public void testUserTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
//        Map map = new HashMap();
//        map.put("id", 11);
//        map.put("name", "Jerry");
//        map.put("pwd", 999888);
//
//        int result = userMapper.addUser(map);
//        if (result > 0) {
//            System.out.println("Add user success!");
//        }
//
//        userMapper.deleteUser(11);
//        if (result > 0) {
//            System.out.println("Delete user success!");
//        }

        List<User> users = userMapper.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
