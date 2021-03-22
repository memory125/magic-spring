package com.wing.test;

import com.wing.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void testPerson1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Person person1 = context.getBean("person1", Person.class);
        person1.getCat().shout();
        person1.getDog().shout();

        Person person2 = context.getBean("person2", Person.class);
        person2.getCat().shout();
        person2.getDog().shout();
    }

    @Test
    public void testPerson2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-autowired-05.xml");

        Person person = context.getBean("person", Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }
}
