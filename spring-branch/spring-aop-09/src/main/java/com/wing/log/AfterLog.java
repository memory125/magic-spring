package com.wing.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author memory125
 */
public class AfterLog implements AfterReturningAdvice {
    /*
        returnValue: 返回值
     */
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName() + " is ran! And the return value is " + returnValue);
    }
}
