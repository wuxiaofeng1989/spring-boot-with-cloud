package com.itmuch.cloud.miscroserviceconsumermoviefeigncustomizing.controller;

import com.itmuch.cloud.miscroserviceconsumermoviefeigncustomizing.entiry.User;
import com.itmuch.cloud.miscroserviceconsumermoviefeigncustomizing.feign.FeignClient2;
import com.itmuch.cloud.miscroserviceconsumermoviefeigncustomizing.feign.UserFeignCliend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieFeignController {

    @Autowired
    private UserFeignCliend userFeignCliend;

    @Autowired
    private  FeignClient2 feignClient2;
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
       return userFeignCliend.findById(id);

    }
    @GetMapping("/{serviceName}")
    public String findServiceName(@PathVariable String serviceName){
        return feignClient2.findServiceNameEureka(serviceName);
    }

}
