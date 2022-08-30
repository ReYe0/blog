package com.study.controller;

import com.study.common.CommonResult;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.entity.dto.BlogResponseDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * @Description: blog
 * 博客curd
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/8/11 10:30
 */
public interface BlogController {
    @PostMapping(value = "/saveOrUpdate",name = "blog保存和修改接口")
    public CommonResult saveOrUpdate(@RequestBody Blog blog);

    @GetMapping(value = "/blogList",name = "blog分页查询接口")
    public CommonResult<BlogResponseDTO> getBlogList(@Valid BlogQueryDTO blogQueryDTO);
}
