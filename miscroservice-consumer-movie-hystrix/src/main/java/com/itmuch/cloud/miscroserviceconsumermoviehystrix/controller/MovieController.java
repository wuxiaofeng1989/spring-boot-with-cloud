package com.itmuch.cloud.miscroserviceconsumermoviehystrix.controller;

import com.itmuch.cloud.miscroserviceconsumermoviehystrix.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class MovieController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/simple/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    public User findById(@PathVariable Long id){
        System.out.println("hello spring boot");
        return restTemplate.getForObject("http://miscroservice-provider-user/simple/"+id,User.class);
    }

    public User findByIdFallBack(@PathVariable Long id){
        User user = new User(1l,"张三");
        return user;
    }

}
