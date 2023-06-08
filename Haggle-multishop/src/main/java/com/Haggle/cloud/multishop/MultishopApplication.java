package com.Haggle.cloud.multishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * /**/ FrozenWatermelon
 * @date 2020/09/03
 */
@SpringBootApplication(scanBasePackages = { "com.Haggle.cloud" })
@EnableFeignClients(basePackages = {"com.Haggle.cloud.api.**.feign"})
public class MultishopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultishopApplication.class, args);
	}

}
