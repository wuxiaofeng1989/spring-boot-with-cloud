package com.itmuch.cloud.miscroserviceprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class MiscroserviceProviderUserApplication {


	public static void main(String[] args) {

		SpringApplication.run(MiscroserviceProviderUserApplication.class, args);
	}

}
