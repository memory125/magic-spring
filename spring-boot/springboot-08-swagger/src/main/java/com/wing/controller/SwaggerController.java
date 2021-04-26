package com.wing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author memory125
 */
@RestController
public class SwaggerController {

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1() {
        return "Get----->Hello,Swagger!";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    public String hello2() {
        return "Post----->Hello,Swagger!";
    }
}
