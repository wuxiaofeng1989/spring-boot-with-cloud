package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign;

import com.itmuch.config.Configuration2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "xxx",url = "http://localhost:8761",fallback =FeignClient2FallBack.class ,configuration = Configuration2.class)
public interface FeignCliend2 {
    @RequestMapping(value = "/eureka/apps/{serviceName}",method = RequestMethod.GET)
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
