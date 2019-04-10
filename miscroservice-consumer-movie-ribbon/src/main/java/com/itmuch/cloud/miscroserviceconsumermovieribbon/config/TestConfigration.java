package com.itmuch.cloud.miscroserviceconsumermovieribbon.config;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class TestConfigration {

    /*@Autowired
    IClientConfig config;*/
    //定义负载均衡规则，这里设置为随机规则
    //自定义的规则如果放在入口类同级包下，所有的负载均衡都被覆盖成本规则。
    @Bean
    public IRule ribbonRule(/*IClientConfig config*/){
        /*
        *随机 (Random)
        *轮询 (RoundRobin)
        *一致性哈希 (ConsistentHash)
        *哈希 (Hash)
        *加权（Weighted）
        **/
        return new RandomRule();
    }
}
