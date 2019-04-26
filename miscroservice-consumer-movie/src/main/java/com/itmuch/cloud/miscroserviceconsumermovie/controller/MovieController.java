package com.itmuch.cloud.miscroserviceconsumermovie.controller;

import com.itmuch.cloud.miscroserviceconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Stack;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id ){
        return restTemplate.getForObject("http://localhost:7900/simple/"+id,User.class);
    }
}
