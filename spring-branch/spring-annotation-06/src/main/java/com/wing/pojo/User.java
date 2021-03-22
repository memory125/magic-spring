package com.wing.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author memory125
 */
// @Component 等价于<bean id="user" class="com.wing.pojo.User" />
@Component
public class User {
    // 相当于 <property name="name" value="Tom" />
    @Value("Tom")
    private String name;
    @Value("1")
    private int id;
    @Value("36")
    private int age;
    @Value("Male")
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
