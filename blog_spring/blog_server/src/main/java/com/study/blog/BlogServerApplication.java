package com.study.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.study.blog.mapper")
@EnableDiscoveryClient
@EnableHystrix
public class BlogServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}

}
