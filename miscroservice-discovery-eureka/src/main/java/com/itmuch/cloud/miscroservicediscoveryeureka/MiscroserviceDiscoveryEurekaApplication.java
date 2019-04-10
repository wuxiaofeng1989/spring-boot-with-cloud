package com.itmuch.cloud.miscroservicediscoveryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MiscroserviceDiscoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscroserviceDiscoveryEurekaApplication.class, args);
	}

}
