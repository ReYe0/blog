package com.study.blog.controller;

import com.study.blog.common.CommonResult;
import com.study.blog.entity.vo.TagListVo;
import org.springframework.web.bind.annotation.GetMapping;

public interface TagController {

    @GetMapping(value = "/tagList",name = "获取全部标签列表")
    public CommonResult<TagListVo> getTagList();
}
