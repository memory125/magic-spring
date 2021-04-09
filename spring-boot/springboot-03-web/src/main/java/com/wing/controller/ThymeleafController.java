package com.wing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author memory125
 */
@Controller
public class ThymeleafController {

    @GetMapping("/thyme")
    public String thyme(Model model) {
        model.addAttribute("msg", "Hello, Thymeleaf!");
        return "thymeleaf";
    }
}
