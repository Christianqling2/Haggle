package com.Haggle.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * /**/ FrozenWatermelon
 * @date 2020/7/23
 */
@SpringBootApplication(scanBasePackages = { "com.Haggle.cloud" })
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
