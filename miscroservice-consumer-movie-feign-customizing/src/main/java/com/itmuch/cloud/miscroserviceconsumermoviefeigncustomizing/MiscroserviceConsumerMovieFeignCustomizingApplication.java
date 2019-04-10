package com.itmuch.cloud.miscroserviceconsumermoviefeigncustomizing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MiscroserviceConsumerMovieFeignCustomizingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscroserviceConsumerMovieFeignCustomizingApplication.class, args);
	}

}
