package com.wing.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author memory125
 */
public class BeforeLog implements MethodBeforeAdvice {
    /*
        method: 要执行的目标对象的方法
        args: 参数
        target: 目标对象
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Class: " + target.getClass().getName() + "'s method === " + method.getName() + " is running!!!");
    }
}
