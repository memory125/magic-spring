package com.wing.pojo;


import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private int age;
    private String name;
    private List<String> cards;
}
