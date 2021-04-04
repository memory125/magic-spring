package com.wing.controller;

import com.wing.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author memory125
 */
@RestController
public class AjaxController {

    @RequestMapping("/h1")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {

        if (name.equals("Jack")) {
            response.getWriter().println("True");
        } else {
            response.getWriter().println("False");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        List<User> users = new ArrayList<User>();

        users.add(new User(1, "Jack", 22, "Male"));
        users.add(new User(2, "Jane", 24, "Female"));
        users.add(new User(3, "David", 26, "Male"));
        users.add(new User(4, "Lida", 28, "Male"));
        users.add(new User(5, "Sam", 27, "Male"));

        return users;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd)  {
        String msg = "";

        // 实际项目中，name需要从数据库中获取并验证
        if (name != null) {
            if (name.equals("admin")) {
                msg = "ok";
            } else {
                msg = "用户名错误！";
            }
        }

        // 实际项目中，pwd需要从数据库中获取并验证
        if (pwd != null) {
            if (pwd.equals("root")) {
                msg = "ok";
            } else {
                msg = "密码错误！";
            }
        }

        return msg;
    }
}
