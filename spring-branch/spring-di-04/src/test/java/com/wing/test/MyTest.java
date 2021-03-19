package com.wing.test;

import com.wing.pojo.Person;
import com.wing.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void testStudent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
        /*
          Student
          {   name='David',
              address=Address{
                  postId=510001,
                  addressInfo='广东省深圳市'
              },
              books=[二十四史, 史记, 国语, 论语, 孙子兵法, 资治通鉴, 春秋, 左传, 挺经, 冰鉴, 庄子, 管子, 战国策, 德道经],
              hobbies=[听歌, 看电影, 码代码, 撩妹, 摄影],
              idCards={
                  身份证=111111222222223333,
                  学生证=2021031920,
                  饭卡=D45641564E,
                  门禁卡=O56654651F,
                  工卡=T2021031908E
              },
              games=[LOL, 王者荣耀, 刺激战场, 绝地求生, 英雄联盟, 狂野时速, 冰封王座, 魔兽争霸],
              house='null',
              info={
                password=123456,
                url=jdbc:mysql://localhost:3306/mydb,
                driver=com.mysql.cj.jdbc.Driver,
                username=root
              }
          }
         */
    }

    @Test
    public void testPerson() {
        ApplicationContext context = new ClassPathXmlApplicationContext("personbean.xml");

        Person person1 = context.getBean("person1", Person.class);
        System.out.println(person1.toString());

        Person person3 = context.getBean("person3", Person.class);
        System.out.println(person3.toString());

        System.out.println("person1: " + person1);
        System.out.println("person3" + person3);
        System.out.println("person1 == person3 ?? " + (person1 == person3));

        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2.toString());
    }
}
