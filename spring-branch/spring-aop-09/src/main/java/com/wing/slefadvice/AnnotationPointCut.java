package com.wing.slefadvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author memory125
 */
@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.wing.service.UserServiceImpl.*(..))")
    public void before()  {
        System.out.println(this.getClass().getName() + " ===== before is running!");
    }

    @After("execution(* com.wing.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println(this.getClass().getName() + " ===== after is running!");
    }

    @AfterReturning("execution(* com.wing.service.UserServiceImpl.*(..))")
    public void afterReturn() {
        System.out.println(this.getClass().getName() + " ===== afterReturn is running!");
    }

    // 在环绕增强中，可以给定一个参数，代表要获取处理切入的点
    @Around("execution(* com.wing.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(this.getClass().getName() + " ===== before around is running!");
        // 执行方法
        Object proceed = proceedingJoinPoint.proceed();

        System.out.println(this.getClass().getName() + " ===== after around is running!");

        Signature signature = proceedingJoinPoint.getSignature();
        System.out.println("Sinature=======" + signature);
    }
}
