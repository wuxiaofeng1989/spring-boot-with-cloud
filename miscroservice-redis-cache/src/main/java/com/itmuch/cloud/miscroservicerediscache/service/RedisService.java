package com.itmuch.cloud.miscroservicerediscache.service;

import com.itmuch.cloud.miscroservicerediscache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations <Object ,Object>valueOperations;

    public String getRedisValuesBy(String key){

        String result = null;
        try {
            result = (String )valueOperations.get(key);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setKeyValuesToRedis(List<User> user){
        valueOperations.set(user.get(2).getId().toString(),user.toString());
    }
}
