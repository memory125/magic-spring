package com.wing.controller;

import com.wing.service.UserService;
import com.wing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MongoDBController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add")
    public String saveUser() {
        User user = new User();
        user.setId(11);
        user.setAge(33);
        user.setName("Jack");
        userService.saveUser(user);
        return "ok";
    }

    @RequestMapping(value="/query")
    public User findTestByName(){
        User user = userService.queryUserByName("Jack");
        System.out.println("user is " + user);
        return user;
    }

    @RequestMapping(value="/update")
    public String updateTest(){
        User user = new User();
        user.setId(11);
        user.setAge(44);
        user.setName("David");
        userService.updateUser(user);
        return "ok";
    }

    @RequestMapping(value="/delete")
    public String deleteTestById(){
        userService.deleteUserById(11);
        return "ok";
    }
}
