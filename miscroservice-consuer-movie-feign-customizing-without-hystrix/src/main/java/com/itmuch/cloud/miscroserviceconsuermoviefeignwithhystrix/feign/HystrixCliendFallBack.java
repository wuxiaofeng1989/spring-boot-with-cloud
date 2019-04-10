package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign;

import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.entity.User;
import feign.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class HystrixCliendFallBack implements UserFeignClient {

    @Override
    public User findById(@Param("id") Long id) {
        User user = new User(10L, "wu");
        return user;
    }
}
