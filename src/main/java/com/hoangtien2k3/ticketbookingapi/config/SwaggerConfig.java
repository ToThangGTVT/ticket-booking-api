package com.hoangtien2k3.ticketbookingapi.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@SecurityScheme(
        name = "bearerAuth", // Tên của Security Scheme
        type = SecuritySchemeType.HTTP, // Loại bảo mật: HTTP
        scheme = "bearer",              // Sử dụng Bearer Token
        bearerFormat = "JWT"            // Định dạng Bearer Token (JWT)
)
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hoangtien2k3.ticketbookingapi"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ticket booking API")
                .description("编程喵是一个 Spring Boot+Vue 的前后端分离项目")
                .contact(new springfox.documentation.service.Contact("ThangTQ", "https://setdanh.io.vn","tothang97nbvn@gmail.com"))
                .version("v1.0")
                .build();
    }
}