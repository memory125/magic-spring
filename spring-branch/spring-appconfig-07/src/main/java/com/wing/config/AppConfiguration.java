package com.wing.config;

import com.wing.pojo.Staff;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author memory125
 */
/*
 这个也是由Spring容器托管，注册到容器中，因为它本身也是一个@Component
 @Configuration代表这是一个配置类，等价于之前的beans.xml
 */
@Configuration
@ComponentScan("com.wing.pojo")
@Import(AppConfiguration2.class)
public class AppConfiguration {

    /* 注册一个Bean，相当于我们之前写的bean标签
       这个方法的名字，相当于bean标签中的id属性
       这个方法的返回值，相当于bean标签中的class属性
     */
    @Bean
    public Staff getStaff() {
        return new Staff();     // 就是返回要注入到bean的对象
    }
}
