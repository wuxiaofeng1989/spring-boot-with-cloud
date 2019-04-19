package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.controller;

import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.entity.User;
import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign.UserFeignCliend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserFeignCliend userFeignCliend;
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeignCliend.findById(id);
    }
}
