package com.wing.test;

import com.wing.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        User user1 = (User) context.getBean("user1");
        User user2 = (User) context.getBean("user2");
        User user3= (User) context.getBean("user3");

        user1.show();
        user2.show();
        user3.show();
    }
}
