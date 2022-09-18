package com.study.controller;

import com.study.common.CommonResult;
import com.study.entity.dto.BlogEditReqDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 19:12
 */
public interface ArchiveController {
    @GetMapping(value = "/archiveCountList",name = "获取归档的日期和blog数量",produces="application/json")
    public CommonResult getArchiveCountList(Integer pageNum, Integer pageSize);

    @GetMapping(value = "/archiveList",name = "blog保存和修改接口",produces="application/json")
    public CommonResult getArchiveList(Integer pageNum, Integer pageSize);
}
