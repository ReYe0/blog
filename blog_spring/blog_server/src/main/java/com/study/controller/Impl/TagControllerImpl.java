package com.study.controller.Impl;

import com.study.common.CommonResult;
import com.study.controller.TagController;
import com.study.entity.vo.TagListVo;
import com.study.service.TagService;
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
