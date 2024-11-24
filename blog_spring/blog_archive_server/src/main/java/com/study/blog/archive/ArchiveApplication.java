package com.study.blog.archive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: blog_spring
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/11/10 20:45
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.study.blog.archive.mapper")
public class ArchiveApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArchiveApplication.class,args);
    }
}
