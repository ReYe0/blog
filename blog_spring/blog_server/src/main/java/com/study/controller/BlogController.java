package com.study.controller;

import com.study.common.CommonResult;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    private BlogService blogService;


    @PostMapping("/saveOrUpdate")
    public CommonResult saveOrUpdate(@RequestBody Blog blog){
        return CommonResult.success(blogService.saveOrUpdate(blog));
    }

    @GetMapping("/blogList")
    public CommonResult getBlogList(@Valid BlogQueryDTO blogQueryDTO){

        return CommonResult.success(blogService.getBlogList(blogQueryDTO));
    }
}

