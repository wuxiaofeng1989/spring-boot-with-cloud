package com.itmuch.cloud.miscroservicrconsumermoviefeign.controller;

import com.itmuch.cloud.miscroservicrconsumermoviefeign.entity.User;
import com.itmuch.cloud.miscroservicrconsumermoviefeign.feign.MovieFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieFeignClient movieFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return movieFeignClient.findById(id);
    }
}
