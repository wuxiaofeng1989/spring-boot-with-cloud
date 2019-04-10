package com.itmuch.cloud.miscroserviceconsumermoviehystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrix
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class MiscroserviceConsumerMovieHystrixRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscroserviceConsumerMovieHystrixRibbonHystrixApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Bean
	public ServletRegistrationBean getServlet(){
   		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
   		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
   		registrationBean.setLoadOnStartup(1);
   		registrationBean.addUrlMappings("/actuator/hystrix.stream");
   		registrationBean.setName("HystrixMetricsStreamServlet");
   		return registrationBean;
	}

}
