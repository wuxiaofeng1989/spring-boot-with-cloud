package com.itmuch.cloud.miscroserviceprovideruser.controller;

import com.itmuch.cloud.miscroserviceprovideruser.entity.User;
import com.itmuch.cloud.miscroserviceprovideruser.repository.UserRepositery;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private UserRepositery userRepositery;

    @GetMapping("/eureka-instance")
    public String serverUrl(){
        InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("MISCROSERVICE-PROVIDER-USER",false);
        return instanceInfo.getHomePageUrl();
    }
    @GetMapping("/simple/{id}")
    public User getUser(@PathVariable Long id){
        System.out.println("进入，user");
        return userRepositery.getOne(id);
    }

    @GetMapping("/list-user")
    public List<User> ListUser(){
        ArrayList<User> list= new ArrayList<User>();
        User user = new User(1L,"张三");
        User user2 = new User(2L,"李四");
        User user3 = new User(3L,"赵五");
        list.add(user);
        list.add(user2);
        list.add(user3);
        return list;
    }
}
