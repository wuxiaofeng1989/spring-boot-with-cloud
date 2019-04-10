package com.itmuch.cloud.miscroserviceconsumermovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTurbine
public class MiscroserviceHystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscroserviceHystrixTurbineApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
