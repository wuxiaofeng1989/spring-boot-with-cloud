package com.itmuch.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuration1 {
    /*
     * 配置feignCliend2的日志
     * */
    @Bean
    Logger.Level feignLoggerLevenl(){
        return Logger.Level.FULL;
    }
}
