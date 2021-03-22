package com.wing.pojo;

import org.springframework.lang.Nullable;

import javax.annotation.Resource;

/**
 * @author memory125
 */
public class Person3 {
    @Resource(name = "dog2")
    private Dog dog;
    @Resource(name = "cat2")
    private Cat cat;
    private String name;

    /*
       @Resouce和@Autowired的区别：
       - 都是用来自动装载的，都可以放在属性字段上；
       - @Autowired 通过ByType的方式实现，而且必须要求这个对象存在(常用)
       - @Resource  默认通过ByName的方式实现，如果找不到名字，则通过ByType实现，如果两个都找不到的情况下，就报错！(常用)
       - 执行顺序不同，@Autowired 通过ByType的方式实现，@Resource 通过ByName的方式实现。
     */

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
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
