package com.wing.test;

import com.wing.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void testHello() {
        // 获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 获取Bean对象
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
