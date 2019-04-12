package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.feign;

import com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class HystrixClinetFactory implements FallbackFactory<UserFeignCliend> {
    private static final Logger Log = LoggerFactory.getLogger(HystrixClinetFactory.class);
    @Override
    public UserFeignCliend create(Throwable throwable) {
        HystrixClinetFactory.Log.info("fallbacky reason was:()",throwable.getMessage());
        return new UserFeignClientWithFactory() {

            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                return user;
            }
        };
    }
}
