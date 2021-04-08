package com.wing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author memory125
 */
/*
    @ConfigurationProperties作用：
    将配置文件中配置的每一个属性的值，映射到这个组件中；
    告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
    参数 prefix = “staff” : 将配置文件中的staff下面的所有属性一一对应
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@PropertySource("classpath:staff.yml") // 加载指定的配置文件
@ConfigurationProperties(prefix = "staff")  // 默认从全局配置文件中获取值
public class Staff {
    private String name;
    private int age;
    private List<String> hobbies;
    private Map<String, Object> credentials;
    private boolean isMarried;
}
