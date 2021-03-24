package com.wing.slefadvice;

/**
 * @author memory125
 */
public class AopAdvice {
    public void before()  {
        System.out.println(this.getClass().getName() + " ===== before is running!");
    }

    public void after() {
        System.out.println(this.getClass().getName() + " ===== after is running!");
    }
}
