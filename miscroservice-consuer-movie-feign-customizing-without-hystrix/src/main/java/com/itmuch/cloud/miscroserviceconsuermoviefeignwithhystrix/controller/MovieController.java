package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.controller;

import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.entity.User;
import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign.FeignCliend2;
import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private FeignCliend2 feignCliend2;
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeignClient.findById(id);
    }

    @GetMapping("/{serviceName}")
    public String findServiceInfo(@PathVariable String serviceName){
        return feignCliend2.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}
