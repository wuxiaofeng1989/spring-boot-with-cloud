package com.itmuch.cloud.miscroserviceconsumermoviehystrix.controller;

import com.itmuch.cloud.miscroserviceconsumermoviehystrix.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@RestController
public class MovieController {
    @Autowired
    RestTemplate restTemplate;

    //配置commandProperties表示本方法和fallbackmethod中的方法在同一个线程中运行。否在二个方法是一个隔离的线程。正常情况不用配置，异常runtimeException
    @GetMapping("/simple/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack",commandProperties = @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"))
    public User findById(@PathVariable Long id){
        System.out.println("hello spring boot");
        return restTemplate.getForObject("http://miscroservice-provider-user/simple/"+id,User.class);
    }

    public User findByIdFallBack(@PathVariable Long id){
        User user = new User(1l,"张三");
        return user;
    }

}
