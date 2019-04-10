package com.itmuch.cloud.miscroserviceconsumermoviefeigncustomizing.feign;

import com.itmuch.cloud.miscroserviceconsumermoviefeigncustomizing.entiry.User;
import com.itmuch.config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//feign使用默认配置,不使用springmvc注解，使用feign的注解
@FeignClient(name = "miscroservice-provider-user",configuration = Configuration1.class)
public interface UserFeignCliend {
    //@RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    @RequestLine(value = "GET /simple/{id}")
    public User findById(@Param("id") Long id);
}
