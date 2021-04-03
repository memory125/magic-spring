package com.wing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author memory125
 */
@RestController
public class AjaxController {

    @RequestMapping("/h1")
    public String hello() {
        return "hello";
    }
}
