package com.study.controller;

import com.study.common.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 分类相关接口
 */
public interface CategoryController {

    @GetMapping(value = "/categoryList",name = "获取分类list接口")
    public CommonResult getCategoryList();

    @GetMapping(value = "/categoryCountList",name = "获取分类和分类的数量")
    public CommonResult getCategoryCountList();
}
