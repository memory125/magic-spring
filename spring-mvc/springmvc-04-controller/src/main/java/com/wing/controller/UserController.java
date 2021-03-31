package com.wing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.wing.pojo.User;


/**
 * @author memory125
 */
@Controller
public class UserController {

    // http://localhost:8080/user/u1?name=Richard
    @GetMapping("/user/u1")
    public String testUser1(String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }

    // http://localhost:8080/user/u2?id=1&name=Richard&age=3
    @GetMapping("/user/u2")
    public String testUser2(User user, Model model) {
        System.out.println(user);
        model.addAttribute("msg", user);
        return "test";
    }
}
