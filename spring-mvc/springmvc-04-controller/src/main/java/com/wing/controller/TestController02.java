package com.wing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author memory125
 */
@Controller
@RequestMapping("/test")
public class TestController02 {

    @RequestMapping("/t2")
    public String test01(Model model) {
        model.addAttribute("msg", "TestController02");
        return "test";
    }

    @RequestMapping("/t3")
    public String test02(Model model) {
        model.addAttribute("msg", "TestController02");
        return "test";
    }
}
