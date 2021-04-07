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
    
## Spring Cloud
