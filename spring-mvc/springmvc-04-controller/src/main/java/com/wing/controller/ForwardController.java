package com.wing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author memory125
 */
@Controller
public class ForwardController {

    // 转发
    @GetMapping("/forward/t1")
    public String forward01(Model model) {
        model.addAttribute("msg", "ForwardController====>test01");
        return "forward01";
    }

    // 转发： forward
    @GetMapping("/forward/t2")
    public String forward02(Model model) {
        model.addAttribute("msg", "ForwardController====>test02");
        return "forward:/WEB-INF/jsp/forward02.jsp";
    }

    // 重定向：redirect
    @GetMapping("/forward/t3")
    public String forward03(Model model) {
        model.addAttribute("msg", "ForwardController====>test03");
        return "redirect:/forward03.jsp";
    }
}
