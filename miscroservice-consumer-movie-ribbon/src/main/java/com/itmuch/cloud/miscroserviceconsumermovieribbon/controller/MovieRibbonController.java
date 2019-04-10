package com.itmuch.cloud.miscroserviceconsumermovieribbon.controller;

import com.itmuch.cloud.miscroserviceconsumermovieribbon.entity.User;
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
    public User findById(@PathVariable Long id){
        System.out.println("hello spring boot");
        //vip 虚拟IP
        return restTemplate.getForObject("http://miscroservice-provider-user/simple/"+id,User.class);
    }
    @GetMapping("/test")
    public String test(@PathVariable() Long id ){
        return id.toString();
    }

    @GetMapping("list-user")
    public List<User> listUser(){
        //wrong
    //List<User> list = this.restTemplate.getForObject("http://miscroservice-provider-user/list-user",List.class);


        //right
        User[] users = this.restTemplate.getForObject("http://miscroservice-provider-user/list-user",User[].class);
        List<User> list2 = Arrays.asList(users);
        for (User user:list2) {
            System.out.println(user.getId());
        }
        return list2;
    }
    @GetMapping("getPortIp")
    public String getServicePortAndId(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("miscroservice-provider-user");
        System.out.println("1111"+serviceInstance.getHost()+":" +serviceInstance.getPort()+":"+ serviceInstance.getServiceId());
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("miscroservice-provider-user2");
        System.out.println("2222"+serviceInstance2.getHost()+":" +serviceInstance2.getPort()+":"+ serviceInstance2.getServiceId());
        return "OK";
    }
}

