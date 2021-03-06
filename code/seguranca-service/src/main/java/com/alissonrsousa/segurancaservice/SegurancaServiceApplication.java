package com.alissonrsousa.segurancaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SegurancaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SegurancaServiceApplication.class, args);
	}
}
