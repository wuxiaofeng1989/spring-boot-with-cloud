package com.itmuch.cloud.miscroservicrconsumermoviefeign.feign;

import com.itmuch.cloud.miscroservicrconsumermoviefeign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("miscroservice-provider-user")
public interface MovieFeignClient {
    //二个坑 1.@GetMapping 不支持。2.@PathVariable必须设置值
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
