package com.study.blog.controller.Impl;

import com.study.blog.common.CommonResult;
import com.study.blog.controller.BlogTypeController;
import com.study.blog.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/11 17:57
 */
@RestController
@RequestMapping("/blogType")
public class BlogTypeControllerImpl implements BlogTypeController {
    @Autowired
    private BlogTypeService blogTypeService;
    @Override

    public CommonResult getBlogTypeList() {
        return CommonResult.success(blogTypeService.getBlogTypeList());
    }
}
