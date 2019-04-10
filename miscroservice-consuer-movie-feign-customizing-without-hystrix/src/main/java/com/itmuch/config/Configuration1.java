package com.itmuch.config;


import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class Configuration1 {

    @Bean
    public Contract feignContract(){
        System.out.println("configuration");
        return new feign.Contract.Default();
    }

}
