package com.wing.config;

import com.wing.controller.SwaggerController;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author memory125
 */
// Spring Boot集成Swagger 3.0的配置
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    //配置类需要注解 @EnableOpenApi @Configuration
    @Bean
    public Docket createRestApi() {
        // 添加全局参数token令牌
        List<RequestParameter> requestParameter = new ArrayList<>();
        requestParameter.add(new RequestParameterBuilder()
                .name("token")
                .description("令牌")
                .required(false)
                .in(ParameterType.HEADER)
                .build());
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).select()
                /*
                    RequestHandlerSelectors：配置要扫描接口的方式
                    any：扫描全部
                    none：不扫描
                    basePackage：指定要扫描的包
                    withMethodAnnotation：扫描方法上的注解
                    withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                 */
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.basePackage("com.wing.controller"))
                .paths(PathSelectors.any())
                .build().globalRequestParameters(requestParameter);
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("memory125", "https://github.com/memory125", "308463374@qq.com");
        return new ApiInfoBuilder()
                .title("接口开发文档3.0")
                .description("By Wing")
                .version("1.0")
                .contact(contact)
                .build();
    }

}