package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Kyu")
                .select().apis(RequestHandlerSelectors.basePackage("com.example.controller")).build();

    }

    private ApiInfo apiInfo() {
         Contact contact = new Contact("", "", "");
        return new ApiInfo("Jedar0k Swagger",
                "自定义",
                "0.1",
                "https://www.baidu.com",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}
