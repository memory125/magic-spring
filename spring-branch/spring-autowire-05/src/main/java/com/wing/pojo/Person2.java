package com.wing.pojo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author memory125
 */
public class Person2 {
    // @Autowired(required = false) 说明这个对象可以为null，否则不允许为空
    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;
    private String name;

    public String getName() {
        return name;
    }

    public Dog getDog() {
        return dog;
    }

    public Cat getCat() {
        return cat;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}
