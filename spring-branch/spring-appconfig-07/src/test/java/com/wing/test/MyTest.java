package com.wing.test;

import com.wing.config.AppConfiguration;
import com.wing.pojo.Staff;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void testConfiguration() {
        // 如果完全使用了配置类方式去做，可以通过AnnotationConfig 上下文来获取容器，通过配置类的class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Staff staff = context.getBean("getStaff", Staff.class);
        System.out.println(staff);
    }
}
