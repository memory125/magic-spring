## Spring Boot继承Druid
### 1. 直接使用druid-spring-boot-starter
- `pom.xml`中需要添加下述依赖包。
```xml
    <!--druid依赖包-->
    <dependency>
    	<groupId>com.alibaba</groupId>
    	<artifactId>druid</artifactId>
    	<version>1.2.6</version>
    </dependency>
    <!--druid-spring-boot-starter依赖 -->
    <dependency>-->
    	<groupId>com.alibaba</groupId>-->
    	<artifactId>druid-spring-boot-starter</artifactId>-->
    	<version>1.2.6</version>-->
    </dependency>
```
- `application.yml`配置。
```yaml
    spring:
      datasource:
        #用于SQL状态监控,stat代表状态,wall代表防火墙
        type: com.alibaba.druid.pool.DruidDataSource
        url: jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=UTC&useSSL=true&useUnicode=true&characterEncoding=UTF-8
        username: root
        password: 123456
        driver-class-name: com.mysql.cj.jdbc.Driver
        druid:
          stat-view-servlet:
            enabled: true
          # 下面为连接池的补充设置，应用到上面所有数据源中
          # 初始化大小，最小，最大
          initial-size: 5
          min-idle: 5
          max-active: 20
          # 配置获取连接等待超时的时间
          max-wait: 60000
          # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
          time-between-eviction-runs-millis: 60000
          # 配置一个连接在池中最小生存的时间，单位是毫秒
          min-evictable-idle-time-millis: 300000
          validation-query: SELECT 1 FROM DUAL
          test-while-idle: true
          test-on-borrow: false
          test-on-return: false
          # 打开PSCache，并且指定每个连接上PSCache的大小
          pool-prepared-statements: true
          #   配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
          max-pool-prepared-statement-per-connection-size: 20
          filters: stat,wall,log4j
          use-global-data-source-stat: true
          # 通过connectProperties属性来打开mergeSql功能；慢SQL记录
          connect-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
            # 添加IP白名单
            #allow:
          # 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
          #deny:
          web-stat-filter:
            # 添加过滤规则
            url-pattern: /*
            # 忽略过滤格式
            exclusions: "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"
```
- 输入http://localhost:8080/druid后，即可看到Druid监控面板。

### 2. 使用代码，可验证登录的方案
- `pom.xml`中需要添加下述依赖包。
  ```xml
      <!--druid依赖包-->
      <dependency>
      	<groupId>com.alibaba</groupId>
      	<artifactId>druid</artifactId>
      	<version>1.2.6</version>
      </dependency>
  ```
 - `application.yml`配置不变
 - 新建`DruidConfig`类，实现以下配置类。
```java
    package com.wing.config;
    
    import com.alibaba.druid.pool.DruidDataSource;
    import com.alibaba.druid.support.http.StatViewServlet;
    import com.alibaba.druid.support.http.WebStatFilter;
    import org.springframework.boot.context.properties.ConfigurationProperties;
    import org.springframework.boot.web.servlet.FilterRegistrationBean;
    import org.springframework.boot.web.servlet.ServletRegistrationBean;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    
    import javax.sql.DataSource;
    import java.util.HashMap;
    import java.util.Map;
    
    /**
     * @author memory125
     */
    /*
       将自定义的 Druid数据源添加到容器中，不再让 Spring Boot 自动创建
       绑定全局配置文件中的 druid 数据源属性到 com.alibaba.druid.pool.DruidDataSource从而让它们生效
       @ConfigurationProperties(prefix = "spring.datasource")：作用就是将 全局配置文件中
       前缀为 spring.datasource的属性值注入到 com.alibaba.druid.pool.DruidDataSource 的同名参数中
    */
    @Configuration
    public class DruidConfig {
    
        @ConfigurationProperties(prefix = "spring.datasource")
        @Bean
        public DataSource getDataSource() {
           return new DruidDataSource();
        }
    
        //配置 Druid 监控管理后台的Servlet；
        //内置 Servlet 容器时没有web.xml文件，所以使用 Spring Boot 的注册 Servlet 方式
        @Bean
        public ServletRegistrationBean statViewServlet() {
            ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    
            // 这些参数可以在 com.alibaba.druid.support.http.StatViewServlet
            // 的父类 com.alibaba.druid.support.http.ResourceServlet 中找到
            Map<String, String> initParams = new HashMap<>();
            initParams.put("loginUsername", "admin"); //后台管理界面的登录账号
            initParams.put("loginPassword", "123456"); //后台管理界面的登录密码
    
            //后台允许谁可以访问
            //initParams.put("allow", "localhost")：表示只有本机可以访问
            //initParams.put("allow", "")：为空或者为null时，表示允许所有访问
            initParams.put("allow", "");
            //deny：Druid 后台拒绝谁访问
            //initParams.put("kuangshen", "192.168.1.20");表示禁止此ip访问
    
            //设置初始化参数
            bean.setInitParameters(initParams);
            return bean;
        }
    
        @Bean
        public FilterRegistrationBean druidStatFilter() {
            FilterRegistrationBean filterRegistrationBean =
                    new FilterRegistrationBean(new WebStatFilter());
            //添加过滤规则
            filterRegistrationBean.addUrlPatterns("/*");
            //添加需要忽略的格式信息
            filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif," +
                    "*.jpg,*.png, *.css,*.ico,/druid/*");
            return filterRegistrationBean;
    
        }
    }
```
- 对于SpringBoot的启动类，加入注解：@ServletComponentScan。
```java
    @SpringBootApplication
    @ServletComponentScan
    public class DataApplication {
    
    	public static void main(String[] args) {
    		SpringApplication.run(DataApplication.class, args);
    	}
    
    }
```
- 启动应用，在http://localhost:8080/druid，登录之后观察Druid监控面板。