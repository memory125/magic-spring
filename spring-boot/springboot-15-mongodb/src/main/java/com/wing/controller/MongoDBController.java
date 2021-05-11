package com.wing.controller;

import com.wing.dao.UserDao;
import com.wing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoDBController {
    @Autowired
    private UserDao userDao;

    @GetMapping(value="/add")
    public void saveUser() throws Exception {
        User user = new User();
        user.setId(11);
        user.setAge(33);
        user.setName("Jack");
        userDao.saveUser(user);
    }

    @GetMapping(value="/query")
    public User findTestByName(){
        User user = userDao.queryUserByName("Jack");
        System.out.println("user is " + user);
        return user;
    }

    @GetMapping(value="/update")
    public void updateTest(){
        User user = new User();
        user.setId(11);
        user.setAge(44);
        user.setName("David");
        userDao.updateUser(user);
    }

    @GetMapping(value="/delete")
    public void deleteTestById(){
        userDao.deleteUserById(11);
    }
}
