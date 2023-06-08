package com.Haggle.cloud.leaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * /**/ leaf
 */
@SpringBootApplication(scanBasePackages = { "com.Haggle.cloud" })
@EnableFeignClients(basePackages = {"com.Haggle.cloud.api.**.feign"})
public class LeafServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeafServerApplication.class, args);
	}

}
