package com.wing.controller;

import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(HttpSession session, Model model) {
        // 如果已经有用户登录
        if (session != null) {
            Map<String, String> userInfo = (Map<String, String>) session.getAttribute("userInfo");
            if (userInfo != null) {
                String username = userInfo.get("user");

                if (username != "") {
                    model.addAttribute("username", username);
                }
            }
        }

        return "main";
    }

    @RequestMapping("/tologin")
    public String goToLogin(HttpSession session, Model model) {
        // 如果已经有用户登录
        if (session != null) {
            Map<String, String> userInfo = (Map<String, String>) session.getAttribute("userInfo");
            if (userInfo !=  null) {
                String username = userInfo.get("user");

                if (username != "") {
                    model.addAttribute("username", username);
                    return "redirect:main";
                }
            }
        }

        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String pwd, Model model) {
        // 把用户的信息存在session中
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("user", username);
        userMap.put("pwd", pwd);
        session.setAttribute("userInfo", userMap);
        model.addAttribute("username", username);

        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 把用户的信息存在session中
       session.removeAttribute("userInfo");
       // session.invalidate();
       return "redirect:/index.jsp";
    }
}
