package com.cg.hsm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Hospital Service Management")
            .description("Created by Pranjali , Diparna, Jyothi, Ramya , Samyuktha, Anjum & Greeshma - Capgemini 29th Dec, 2020 Batch FullStack Development with ReactJs")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .build();
    }

    @SuppressWarnings("unchecked")
	@Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.cg.hsm"))
            .build()
            .apiInfo(apiInfo());
    }
}
