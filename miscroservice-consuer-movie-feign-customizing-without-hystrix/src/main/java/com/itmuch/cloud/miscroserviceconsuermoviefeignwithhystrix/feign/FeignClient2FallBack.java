package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
@Component
public class FeignClient2FallBack implements FeignCliend2 {
    @Override
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName){
        return "hahaha";
    }


}
