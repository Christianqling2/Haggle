package com.Haggle.cloud.auth.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableKnife4j
public class SwaggerConfiguration {


	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("auth服务")
				.packagesToScan("com.Haggle.cloud.auth.controller")
				.pathsToMatch("/**")
				.build();
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Haggle商城接口文档")
						.description("Haggle商城接口文档Swagger版")
						.version("v0.0.1")
						.license(new License().name("使用请遵守商用授权协议").url("https://www.Haggle.com")));
	}
}
