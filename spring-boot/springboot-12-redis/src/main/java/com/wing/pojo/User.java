package com.wing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author memory125
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
// 实体类序列化在后面加上 implements Serializable
public class User {
    private String name;
    private int age;
}
