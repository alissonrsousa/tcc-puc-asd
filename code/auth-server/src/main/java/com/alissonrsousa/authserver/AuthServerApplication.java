package com.alissonrsousa.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
public class AuthServerApplication {

	public static void main(String[] args) {
//		matches();
		SpringApplication.run(AuthServerApplication.class, args);
	}
	
	private static void encript() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("123456"));
		
		System.out.println("$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy".equals(encoder.encode("123456")));
	}
	
	private static void matches() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("[" + encoder.matches("123456","$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy") + "]");
	}
}
