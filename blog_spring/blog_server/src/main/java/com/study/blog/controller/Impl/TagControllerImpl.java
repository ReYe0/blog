package com.study.blog.controller.Impl;

import com.study.blog.common.CommonResult;
import com.study.blog.controller.TagController;
import com.study.blog.entity.vo.TagListVo;
import com.study.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagControllerImpl implements TagController {
    @Autowired
    private TagService tagService;
    @Override
    public CommonResult<TagListVo> getTagList() {
        return CommonResult.success(tagService.getTagList());
    }
}
