package com.itmuch.cloud.miscroservicerediscache.controller;

import com.itmuch.cloud.miscroservicerediscache.entity.User;
import com.itmuch.cloud.miscroservicerediscache.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;
    @GetMapping("/get/{key}")
    public String get(@PathVariable("key") String key){
        return redisService.getRedisValuesBy(key);

    }
    @GetMapping("/set")
    public String set(){
        User user = new User(0l,"张三");
        User user1 = new User(1l,"李四");
        User user2 = new User(2l,"赵武");
        User user3 = new User(3l,"王六");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        redisService.setKeyValuesToRedis(userList);

        return "OK";
    }
}
