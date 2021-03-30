package com.wing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author memory125
 */

@Controller
public class RestfulController {

    // 请求式样: http://localhost:8080/add?a=1&b=2
    @RequestMapping("/add")
    public String add1(int a, int b, Model model) {
        int result = a + b;
        model.addAttribute("msg", "add1结果为： " + result);

        return "test";
    }


    @RequestMapping("/add/{a}/{b}")
    public String add2(@PathVariable int a, @PathVariable int b, Model model) {
        int result = a + b;
        model.addAttribute("msg", "add2结果为： " + result);

        return "test";
    }

    // 请求式样： http://localhost:8080/add/1/2
    @GetMapping("/add/{a}/{b}")
    public String add3(@PathVariable int a, @PathVariable int b, Model model) {
        int result = a + b;
        model.addAttribute("msg", "add3结果为： " + result);

        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String add4(@PathVariable int a, @PathVariable int b, Model model) {
        int result = a + b;
        model.addAttribute("msg", "add4结果为： " + result);

        return "test";
    }

}
