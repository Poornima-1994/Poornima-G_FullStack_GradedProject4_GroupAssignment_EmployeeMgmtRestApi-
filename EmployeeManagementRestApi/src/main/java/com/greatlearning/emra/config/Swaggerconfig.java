package com.greatlearning.emra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2


public class Swaggerconfig {
	
	@Bean
	public Docket emraAPI() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(ApiInfo()).groupName("Employee Managment - Rest API")
				.select().apis(RequestHandlerSelectors.basePackage("org.greatlearning.emra")).build();
	}

	public ApiInfo ApiInfo() {
		return new ApiInfoBuilder().title(" Employee Managment Rest API")
				.description("Employee Management Rest Api based Web application, "
						+ "where we will be developing CRUD(Create, Read, Update and Delete) "
						+ "functionality along with Sorting and concepts of Basic Auth and some basic concept of Security")
				.version("1.0").build();
	}
}


