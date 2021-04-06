package com.wing.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author memory125
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session
        HttpSession session = request.getSession();

        // 判断session是否为空, 放行
        if (session.getAttribute("userInfo") != null) {
            return true;
        }

        // 判断请求的url是否包含登录请求，放行
        if (request.getRequestURI().contains("tologin")) {
            return true;
        }

        // 判断请求的url是否包含登录，放行
        if (request.getRequestURI().contains("login")) {
            return true;
        }

        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
