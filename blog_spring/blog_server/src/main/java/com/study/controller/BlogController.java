package com.study.controller;

import com.study.common.CommonResult;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.entity.dto.BlogResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface BlogController {
    @PostMapping(value = "/saveOrUpdate",name = "blog保存和修改接口")
    public CommonResult saveOrUpdate(@RequestBody Blog blog);

    @GetMapping(value = "/blogList",name = "blog分页查询接口")
    public CommonResult<BlogResponseDTO> getBlogList(@Valid BlogQueryDTO blogQueryDTO);
}
