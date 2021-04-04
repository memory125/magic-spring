package com.wing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
}
