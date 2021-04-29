# magic-spring
Spring framework, Spring Boot and even Spring Cloud...

## Spring Framework
- The basic concepts of spring framework.
    - IOC: Inversion of Control(控制反转)
    - AOP: Spring's Aspect-Oriented Programming(面向切面编程)
- The simple samples of spring project.
    - IOC
        - Create spring project via IDEA.
        - Create the configuration file, e.g. beans.xml
        - The file structure of spring configuration. 
        - Configure the primary spring configuration.
        - Create test sample to validate spring project.        
    - DI(dependency injection)
        - The primary dependency injection for spring project.
        - `bean`,  `property`, `list`, `map`, `set`...
    - Annotation
        - `Autowire` via configuration file.
        -  `Autowired` via Java source code.

## SpringMVC
- Review the Servlet application.
- The basic concepts of SpringMVC.
- Create SpringMVC sample project via IDEA.
- The 1st sample on SpringMVC.
- Spring annotation development.
- The difference between `Class` and `Annotation`.
    - Create the specific sample.
    - Controller01 is implemented via Class implements `SpringMVC Controller`.
    - Controller02 is implemented via `SpringMVC Annotation`, obviously it is more convenient than `SpringMVC Controller`.
    - The configuration for `SpringMVC Annotation` is critical, please refer to the following configuration.
    ```xml
       <?xml version="1.0" encoding="UTF-8"?>
       <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:aop="http://www.springframework.org/schema/cache"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       https://www.springframework.org/schema/mvc/spring-mvc.xsd
       http://www.springframework.org/schema/cache
       http://www.springframework.org/schema/cache/spring-cache.xsd">

        <!-- 自动扫描包，让指定包下的注解生效,由IOC容器统一管理 -->
        <context:component-scan base-package="com.wing.controller"/>
        <!-- 让Spring MVC不处理静态资源 -->
        <mvc:default-servlet-handler />
        <!--开启SpringMVC注解-->
        <mvc:annotation-driven />
        <!--开启SpringContext注解-->
        <!--    <context:annotation-config />-->

        <!-- 视图解析器 -->
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"
              id="internalResourceViewResolver">
            <!-- 前缀 -->
            <property name="prefix" value="/WEB-INF/jsp/" />
            <!-- 后缀 -->
            <property name="suffix" value=".jsp" />
        </bean>

        <!--注册TestController01-->
        <!--    <bean id="/t1" class="com.wing.controller.TestController01"/>-->

    </beans>
    ``` 
    - We can copy the above `xml` file as SpringMVC configure file.
    - Restful style controller.
    - Solve the character encoding issue for display.
    - `forward` and `redirect`.
- Data format sample via `Json`.
- The most important sample is integrate `Spring`,`SpringMVC` and `Mybatis` frameworks (**`springmvc-06-ssm-integration`**) to be the scaffold for Spring development.
    - Web configuration (`web.xml`), which is for Servlet registry.
    - Spring configuration (`Spring-dao.xml`, `Spring-service.xml`, IoC,AOP).
    - SpringMVC configuration (`Springmvc-controller.xml`, tag `mvc`).
    - Mybatis configuration (`mybatis-config.xml`, `BookMapper.xml`)
    - Database connection configuration (`do.properties`).
- Send requests from frontend to backend via `Ajax`.
    - Send the request via `jQuery.post` or `jQuery.get`.
    - Add the `jQuery` dependency to project.
        ```js
        <%--引入jQuery--%>
        <script src="${pageContext.request.contextPath}/statics/jquery.js"></script>
      ```
    - Could refer to the following snippet.
    ```js
      function verifyName() {
                  $.post({
                      url: "${pageContext.request.contextPath}/a3",
                      data:{"name": $("#name").val()},
                      success: function (data, status) {
                          if (data.toString() === "ok") {
                              $("#userinfo").css("color", "green");
                          } else {
                              $("#userinfo").css("color", "red");
                          }
                          $("#userinfo").html(data);
                      }
                  });
              }  
    ```
    
- `Interceptor` is used to filter some special requests.
    - Create `Interceptor` implements the interface `HandlerInterceptor`.
    - Configure the `Interceptor` as the following `mvc` configuration.
    ```xml
      <!--配置拦截器-->
          <mvc:interceptors>
              <mvc:interceptor>
                  <!--/** 包括路径及其子路径-->
                  <!--/admin/* 拦截的是/admin/add等等这种 , /admin/add/user不会被拦截-->
                  <!--/admin/** 拦截的是/admin/下的所有-->
                  <mvc:mapping path="/**"/>
                  <!--bean配置的就是拦截器-->
                  <bean class="com.wing.config.MyInterceptor"/>
              </mvc:interceptor>
              <mvc:interceptor>
                <!--登录拦截器-->
                  <mvc:mapping path="/user/**"/>
                  <!--bean配置的就是拦截器-->
                  <bean class="com.wing.config.LoginInterceptor"/>
              </mvc:interceptor>
          </mvc:interceptors>
    ```
- File uploading and download.
    
## Spring Boot
- The basic concepts of Spring Boot.
    - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
    - Create stand-alone Spring applications.      
    - Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files).
    - Provide opinionated `starter` dependencies to simplify your build configuration.      
    - Automatically configure Spring and 3rd party libraries whenever possible.      
    - Provide production-ready features such as metrics, health checks, and externalized configuration.
    - Absolutely no code generation and no requirement for XML configuration.
    - The Spring Boot application has a parent dependency as the following.
    ```xml
         <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.4.4</version>
            <relativePath/> <!-- lookup parent from repository -->
         </parent>
    ```
    - All dependencies for `Spring Boot` are began as `spring-boot-starter`.
- Create Spring Boot project.
    - By `https://start.spring.io/`.
    - By IDEA2020.
- Spring Boot principle.
    - `pom.xml` includes all information and dependencies for Spring Boot application.
    -  `spring-boot-dependencies` is the core dependencies file contains all related dependencies for Spring Boot. Here is just sinppet.
    ```xml
    <properties>
        <activemq.version>5.16.1</activemq.version>
        <antlr2.version>2.7.7</antlr2.version>
        <appengine-sdk.version>1.9.87</appengine-sdk.version>
        <artemis.version>2.15.0</artemis.version>
        <aspectj.version>1.9.6</aspectj.version>
        <assertj.version>3.18.1</assertj.version>
        <atomikos.version>4.0.6</atomikos.version>
        <awaitility.version>4.0.3</awaitility.version>
        <bitronix.version>2.1.4</bitronix.version>
        <build-helper-maven-plugin.version>3.2.0</build-helper-maven-plugin.version>
        <byte-buddy.version>1.10.22</byte-buddy.version>
        <caffeine.version>2.8.8</caffeine.version>
        <cassandra-driver.version>4.9.0</cassandra-driver.version>
        <classmate.version>1.5.1</classmate.version>
        <commons-codec.version>1.15</commons-codec.version>
        <commons-dbcp2.version>2.8.0</commons-dbcp2.version>
        <commons-lang3.version>3.11</commons-lang3.version>
        <commons-pool.version>1.6</commons-pool.version>
        <commons-pool2.version>2.9.0</commons-pool2.version>
        <couchbase-client.version>3.0.10</couchbase-client.version>
        <db2-jdbc.version>11.5.5.0</db2-jdbc.version>
        <dependency-management-plugin.version>1.0.11.RELEASE</dependency-management-plugin.version>
        <derby.version>10.14.2.0</derby.version>
        <dropwizard-metrics.version>4.1.18</dropwizard-metrics.version>
        <ehcache.version>2.10.6</ehcache.version>
        <ehcache3.version>3.9.2</ehcache3.version>
        <elasticsearch.version>7.9.3</elasticsearch.version>
        <embedded-mongo.version>2.2.0</embedded-mongo.version>
        <flyway.version>7.1.1</flyway.version>
        <freemarker.version>2.3.31</freemarker.version>
        <git-commit-id-plugin.version>3.0.1</git-commit-id-plugin.version>
        <glassfish-el.version>3.0.3</glassfish-el.version>
        <glassfish-jaxb.version>2.3.3</glassfish-jaxb.version>
        <groovy.version>2.5.14</groovy.version>
        <gson.version>2.8.6</gson.version>
        <h2.version>1.4.200</h2.version>
        <hamcrest.version>2.2</hamcrest.version>
        <hazelcast.version>4.0.3</hazelcast.version>
        <hazelcast-hibernate5.version>2.1.1</hazelcast-hibernate5.version>
        <hibernate.version>5.4.29.Final</hibernate.version>
        <hibernate-validator.version>6.1.7.Final</hibernate-validator.version>
        <hikaricp.version>3.4.5</hikaricp.version>
        <hsqldb.version>2.5.1</hsqldb.version>
        <htmlunit.version>2.44.0</htmlunit.version>
        <httpasyncclient.version>4.1.4</httpasyncclient.version>
        <httpclient.version>4.5.13</httpclient.version>
        <httpcore.version>4.4.14</httpcore.version>
        <infinispan.version>11.0.10.Final</infinispan.version>
        ...
      </properties>
    ```
  - When we import above dependencies to Spring Boot application, the version for these dependencies are specified via Spring Boot.
  - `starter` is super important for Spring Boot application. Please refer to [Spring Boot Starter](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot).
  - Annotation.
      ```xml
        - @SpringBootApplication 
          - @SpringBootConfiguration  - SpringBoot的配置
            - @Configuration          - Spring配置类
              - @Component            - 说明这也是一个Spring的组件
                 
          - @EnableAutoConfiguration  - 自动配置
            - @AutoConfigurationPackage - 自动配置包
              - @Import({Registrar.class}) - 导入包注册
            - @Import({AutoConfigurationImportSelector.class}) - 导入自动配置选择器
          
          - @ComponentScan            - 组件扫描
            - @Repeatable(ComponentScans.class) - 包扫描
      ```
    - `META-INF/spring.factories` is the core configuration file for Spring Boot, which stored in `spring-boot-autoconfigure-2.4.4.jar`. 
- Spring Boot Configuration.
    - `Properties`, which is key feature for Spring Boot application.
    - The configurable properties can refer to [`Spring Properties`](https://docs.spring.io/spring-boot/docs/2.4.4/reference/html/appendix-application-properties.html#common-application-properties).
    - The configuration file is end with `.yaml` or `.yml`, which is recommended via Spring official site.
    - The sample configuration can refer to the following snippet.
    ```yaml
      # 服务器端口
      server:
        port: 8081
      
       # 数据库配置
      spring:
        datasource:
          driver-class-name: com.mysql.cj.jdbc.Driver
          url: jdbc:mysql://127.0.0.1:3306/db?useSSL=true&useUnicode=true&characterEncoding=UTF-8
          username: root
          password: 123456
    ```
    - Configuration file path.
        - `file: /` : current project root dir. 
        - `file:./config/`: sub dir under current project root .
        - `classpath:/` : current resources path.
        - `classpath:/config/` : sub dir under current resources path.
 - Spring Boot Application - Web, **`springboot-03-web`** is super important for learning. 
    - Create Spring Boot Web application via IDEA.
    - Integrate the Thymeleaf framework to web project.
        - The syntax of Thymeleaf framework.
        - Import Thymeleaf namespace to html file. 
        ```html
              <!DOCTYPE html>
              <html lang="en" xmlns:th="http://www.thymeleaf.org">
        ```
        - Edit Thymeleaf `html` file.
    - Internationalize for Spring Boot project.
        - Create `i18n` directory.
        - Add `xxx.properties` file under `i18n` dir.
        - Add `xxx_en_US.properties` and `xxx_zh_CN.properties` under `i18n` dir.
        - Bundle these file to `Resouce Bundle 'xx''`.
        - Edit above files according to the specific languages.
    - Integrates data connection.
        - Create Spring Boot application with JDBC, MySQL driver project.
        ```xml
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-jdbc</artifactId>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>      			
            </dependency>      
        ```
      - Configure the datasource via `yml`.
        ```xml
           spring:
             datasource:
               #用于SQL状态监控,stat代表状态,wall代表防火墙
               type: com.alibaba.druid.pool.DruidDataSource
               url: jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=UTC&useSSL=true&useUnicode=true&characterEncoding=UTF-8
               username: root
               password: 123456
               driver-class-name: com.mysql.cj.jdbc.Driver
        ```
      - Import and configure different datasource, implement sample via `Druid`.
      ```xml
        <!--druid依赖包-->
        <dependency>
        	<groupId>com.alibaba</groupId>
        	<artifactId>druid</artifactId>
        	<version>1.2.6</version>
        </dependency>
        ``` 
      and the datasource type should be
      ```xml
      spring:
         datasource:
              type: com.alibaba.druid.pool.DruidDataSource
      ```
      - Implementing the monitoring web via configure `Druid` special configuration.
    - Integrate Mybatis for data persistence.
      - Import the mybatis dependency.
        ```xml
        <dependency>
          <groupId>org.mybatis.spring.boot</groupId>
          <artifactId>mybatis-spring-boot-starter</artifactId>
          <version>2.1.4</version>
        </dependency>
        ```
      - Configure basic Mybatis configuration,including package alias and the location of mapper file.
        ```yaml
        # 集成Mybatis
        mybatis.type-aliases-package=com.wing.pojo
        mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
        ```
      - Create mapper interface like the following.
       ```java
          // @Mapper：表示这是一个Mybatis的mapper类 - Dao
          @Mapper
          @Repository
          public interface UserMapper {
              // 查询所有用户
              List<User> queryAllUsers();
          
              // 根据ID查询用户
              User queryUserById(int id);
          
              // 添加用户
              int addUser(User user);
          
              // 修改用户信息
              int updateUser(User user);
          
              // 删除用户
              int deleteUserById(int id);          
          }
       ```
      - CRUD operation,configure the mapper file according to the specific operation, such as `select`,`insert`,`update` and `delete`.        
      
    

    
## Spring Cloud
