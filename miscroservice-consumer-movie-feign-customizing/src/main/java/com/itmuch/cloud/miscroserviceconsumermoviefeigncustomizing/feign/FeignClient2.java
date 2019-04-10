package com.itmuch.cloud.miscroserviceconsumermoviefeigncustomizing.feign;

import com.itmuch.config.Configuration2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "wu",url = "localhost:8761",configuration = Configuration2.class)
public interface FeignClient2 {
    @RequestMapping(value = "/eureka/apps/{serviceName}")
    public String findServiceNameEureka(@PathVariable("serviceName")String serviceName);
}
