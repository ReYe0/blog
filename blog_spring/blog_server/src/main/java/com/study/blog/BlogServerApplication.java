package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.study.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = )
public class BlogServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}

}
