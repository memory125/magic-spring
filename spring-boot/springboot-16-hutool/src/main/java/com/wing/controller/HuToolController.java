package com.wing.controller;

import cn.hutool.Hutool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author memory125
 */
@Controller
public class HuToolController {

    @RequestMapping("/t1")
    public String test1() {
        return "hutool test";
    }
}
