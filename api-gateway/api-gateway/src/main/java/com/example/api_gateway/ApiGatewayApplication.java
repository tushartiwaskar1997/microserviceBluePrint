package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
//		✅ Optional Enhancements
//		Add CORS config
//		Add rate limiting
//		Add global filters (auth, logging, etc.)
//		Swagger aggregation
//		Would you like me to:
//		Upload the gateway scaffold to GitHub?
//		Add Swagger support for gateway routing?
//		Create a fallback/timeout config?
//		Central Config Server?
//		API Gateway with Auth?
//		Rate Limiting / Circuit Breaker?
	}
}
