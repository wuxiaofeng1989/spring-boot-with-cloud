package com.itmuch.config;

import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
    /*
    * 默认feign整合了hystrix,这里是覆盖默认配置使用feign自己的配置
    *
    * */
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
