package com.study.blog.controller.Impl;

import com.study.blog.controller.CategoryController;
import com.study.blog.common.CommonResult;
import com.study.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Override
    public CommonResult getCategoryList() {
        return CommonResult.success(categoryService.getCategoryList());
    }

    @Override
    public CommonResult getCategoryCountList() {
//        List<CategoryCountVo> categoryCountList = categoryService.getCategoryCountList();
        return CommonResult.success(categoryService.getCategoryCountList());
    }
}
