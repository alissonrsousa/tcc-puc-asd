package com.alissonrsousa.apigateway;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alissonrsousa.apigateway.filter.SimpleFilter;

@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping(value = "/api")
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	public SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	}
	
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Principal principal) {
    	OAuth2Authentication oAuth2Authentication =  (OAuth2Authentication) principal;
        return oAuth2Authentication.getUserAuthentication().getName();
    }
}
