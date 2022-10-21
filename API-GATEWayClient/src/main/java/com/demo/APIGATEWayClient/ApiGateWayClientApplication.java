package com.demo.APIGATEWayClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGateWayClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayClientApplication.class, args);
	}

}
