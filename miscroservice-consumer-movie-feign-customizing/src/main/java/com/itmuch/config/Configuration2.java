package com.itmuch.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
@Configuration
public class Configuration2 {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","123");
    }
    /*
    * 配置feignCliend2的日志
    * */
    @Bean
    Logger.Level feignLoggerLevenl(){
        return Logger.Level.FULL;
    }
}
