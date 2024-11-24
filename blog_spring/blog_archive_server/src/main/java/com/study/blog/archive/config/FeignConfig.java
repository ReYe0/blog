package com.study.blog.archive.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: blog_spring
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/11/11 17:07
 */
@Configuration
public class FeignConfig {
//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
    @Bean
    @Scope(value="prototype")
    public IRule loadBalanceRule(){
        return new RandomRule();
    }
}
