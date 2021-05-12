package com.wing.controller;

import com.wing.service.UserService;
import com.wing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class MongoDBController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add")
    public String saveUser() {
        User user = new User();
        List<String> list = new ArrayList<>();
        user.setId(12);
        user.setAge(36);
        user.setName("David");
        list.add("身份证");
        list.add("学生卡");
        list.add("饭卡");
        user.setCards(list);
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
