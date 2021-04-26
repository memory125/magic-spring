package com.wing.config;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
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
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build().globalRequestParameters(requestParameter);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口开发文档3.0")
                .description("By Wing")
                .version("1.0")
                .contact(new Contact("memory125", "https://github.com/memory125", "308463374@qq.com"))
                .build();
    }

}