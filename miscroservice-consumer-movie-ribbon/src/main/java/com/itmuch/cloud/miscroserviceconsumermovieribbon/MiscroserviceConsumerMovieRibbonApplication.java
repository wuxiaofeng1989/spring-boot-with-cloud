package com.itmuch.cloud.miscroserviceconsumermovieribbon;

import com.itmuch.cloud.miscroserviceconsumermovieribbon.config.ExcludeFromComponentScan;
import com.itmuch.cloud.miscroserviceconsumermovieribbon.config.TestConfigration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "miscroservice-provider-user",configuration = TestConfigration.class)//自定义负载均衡的规则，默认是轮循
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})
public class MiscroserviceConsumerMovieRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscroserviceConsumerMovieRibbonApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
