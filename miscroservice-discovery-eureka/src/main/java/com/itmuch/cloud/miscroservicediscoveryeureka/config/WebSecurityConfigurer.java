package com.itmuch.cloud.miscroservicediscoveryeureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*  新版的security默认启用了csrf检验，如果不关闭该检验，
        eureka client端向eureka server注册时，会报如下异常：
        com.netflix.discovery.shared.transport.TransportException:
        Cannot execute request on any known server，
        由于还没研究在启用csrf检验的情况下，eureka client注册服务时如何避免该异常，考虑先关闭csrf检验：*/
        http.csrf().disable();
        super.configure(http);
    }
}
