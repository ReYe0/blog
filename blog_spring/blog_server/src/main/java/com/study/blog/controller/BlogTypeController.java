package com.study.controller;

import com.study.common.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/11 17:54
 */
public interface BlogTypeController {
    @GetMapping(value = "/getBlogTypeList",name = "获取博客类型list",produces="application/json")
    public CommonResult getBlogTypeList();
}
