package com.study.controller.Impl;

import com.study.common.CommonResult;
import com.study.controller.CategoryController;
import com.study.entity.vo.CategoryCountVo;
import com.study.mapper.CategoryMapper;
import com.study.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
