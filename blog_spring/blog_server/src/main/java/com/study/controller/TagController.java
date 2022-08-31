package com.study.controller;

import com.study.common.CommonResult;
import com.study.entity.vo.TagListVo;
import org.springframework.web.bind.annotation.GetMapping;

public interface TagController {

    @GetMapping(value = "/tagList",name = "获取全部标签列表")
    public CommonResult<TagListVo> getTagList();
}
