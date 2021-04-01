package com.wing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wing.pojo.User;
import com.wing.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author memory125
 */
// RestController: 所有接口返回json数据，不解析视图
//@Controller： 解析试图，需要返回json数据时，配合 @ResponseBody使用
@RestController
public class UserController {

    @RequestMapping("/j1")
    //@ResponseBody
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "程嘉禄", 35);

        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    //@ResponseBody
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<User>();
        User user1 = new User(1, "程嘉禄", 35);
        User user2 = new User(2, "陈佳佳", 32);
        User user3 = new User(3, "沈万三", 31);
        User user4 = new User(4, "刘悦婷", 33);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = mapper.writeValueAsString(userList);
        return str;
    }

    @RequestMapping("/j3")
    //@ResponseBody
    public String json3() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.jsonFormat(date, "yyyy-MM-dd HH:mm:ss");
    }
}
