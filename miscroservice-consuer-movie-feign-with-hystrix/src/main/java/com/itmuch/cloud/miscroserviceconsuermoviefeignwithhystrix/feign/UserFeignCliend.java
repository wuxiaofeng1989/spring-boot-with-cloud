package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign;

import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.entity.User;
import com.itmuch.config.Configuration1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "miscroservice-provider-user",fallback =HystrixCliendFallBack.class,configuration = Configuration1.class)
public interface UserFeignCliend {
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
