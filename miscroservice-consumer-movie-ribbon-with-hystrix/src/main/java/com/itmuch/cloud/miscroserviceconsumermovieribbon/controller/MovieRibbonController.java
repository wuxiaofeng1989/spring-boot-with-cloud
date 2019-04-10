package com.itmuch.cloud.miscroserviceconsumermovieribbon.controller;

import com.itmuch.cloud.miscroserviceconsumermovieribbon.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieRibbonController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/simple/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    public User findById(@PathVariable Long id){
        System.out.println("hello spring boot");
        //vip 虚拟IP
        return restTemplate.getForObject("http://miscroservice-provider-user/simple/"+id,User.class);
    }

    public User findByIdFallBack(@PathVariable Long id){
        User user = new User();
        user.setId(0L);
        return user;
    }

}

