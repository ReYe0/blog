package com.study.controller;

import com.study.common.CommonResult;
import com.study.entity.dto.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * @Description: blog
 * 博客curd
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/8/11 10:30
 */
public interface BlogController {
    @PostMapping(value = "/saveOrUpdate",name = "blog保存和修改接口",produces="application/json")
    public CommonResult saveOrUpdate(@RequestBody BlogEditReqDTO blogEditReqDTO);

    @GetMapping(value = "/getBlogEdit/{id}",name = "blog编辑获取信息接口",produces="application/json")
    public CommonResult getBlogEdit(@PathVariable("id") Long id);

    @GetMapping(value = "/blogList",name = "blog分页查询接口",produces="application/json")
    public CommonResult<BlogPageResDTO> getBlogList(@Valid BlogPageReqDTO blogPageReqDTO);

    @PostMapping(value = "/blogBackList",name = "blog后台分页查询接口",produces="application/json")
    public CommonResult<BlogPageBackResDTO> getBlogBackList(@RequestBody BlogPageBackReqDTO blogPageBackReqDTO);

    @GetMapping(value = "/{id}",name = "获取博客详情",produces ="application/json" )
    public CommonResult<BlogDetailDTO> getBlogDetail(@PathVariable("id") Long id);

    @GetMapping(value = "/changeStatus/{id}",name = "改变文章发布状态",produces ="application/json" )
    public CommonResult changeStatus(@PathVariable("id") Long id);

    @GetMapping(value = "/changeIsTop/{id}",name = "改变文章顶置状态",produces ="application/json" )
    public CommonResult changeIsTop(@PathVariable("id") Long id);

    @GetMapping(value = "/hotBlogList",name = "获取热门文章",produces ="application/json" )
    public CommonResult getHotBlogList();
}
