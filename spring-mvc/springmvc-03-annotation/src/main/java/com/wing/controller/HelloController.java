package com.wing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author memory125
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    //真实访问地址 : localhost:8080/hello/h1
    @RequestMapping("h1")
    public String hello(Model model) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg", "Hello, SpringMVC Annotation!");
        //web-inf/jsp/hello.jsp
        return "hello";
    }
}
