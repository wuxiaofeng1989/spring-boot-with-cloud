package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign;

import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.entity.User;
import com.itmuch.config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "miscroservice-provider-user",fallback =HystrixCliendFallBack.class ,configuration = Configuration1.class)
public interface UserFeignClient {
    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);
}
