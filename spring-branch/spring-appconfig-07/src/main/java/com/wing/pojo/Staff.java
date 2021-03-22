package com.wing.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author memory125
 */
@Component
public class Staff {
    private int id;
    private String name;
    private int age;
    private String gender;

    public int getId() {
        return id;
    }

    @Value("2")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Value("Jerry")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Value("36")
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    @Value("Male")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
