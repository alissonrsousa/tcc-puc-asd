package com.alissonrsousa.segurancaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableAutoConfiguration(exclude = { 
    SecurityAutoConfiguration.class 
})
public class SegurancaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SegurancaServiceApplication.class, args);
	}
}
