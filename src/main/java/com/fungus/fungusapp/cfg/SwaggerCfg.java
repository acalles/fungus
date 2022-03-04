package com.fungus.fungusapp.cfg;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerCfg {

   /*  @Bean
    public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fungus.fungusapp.basic"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
    } */

    private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Fungus Service API",
				"Fungus Service API Description",
				"1.0",
				"Fungus",
				new Contact("Fungus", "https://fungus.com", "apis@fungus.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
 
    @Bean
	public Docket greetingApi() {
			return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("application.controller"))
			.build()
			.apiInfo(getApiInfo());
	}
 }
