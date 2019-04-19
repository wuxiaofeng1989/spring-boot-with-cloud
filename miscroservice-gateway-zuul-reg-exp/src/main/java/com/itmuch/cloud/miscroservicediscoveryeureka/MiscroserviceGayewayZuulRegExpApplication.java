package com.itmuch.cloud.miscroservicediscoveryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class MiscroserviceGayewayZuulRegExpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscroserviceGayewayZuulRegExpApplication.class, args);
	}
	/*
	* "利用正则表达式把serverName-v*映射成v* /serverName
	*
	* */
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(?<name>^.+)-(?<version>v.+$)",
				"${version}/${name}");
	}

}
