package com.study.controller;

import com.study.common.CommonResult;
import com.study.entity.Blog;
import com.study.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Description: blog
 * 博客curd
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/8/11 10:30
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogMapper blogMapper;


    @PostMapping("/saveOrUpdate")
    public CommonResult saveOrUpdate(@RequestBody Blog blog){
        blog.setDescription("hhhh");
        return CommonResult.success(blogMapper.insert(blog));
    }
}

