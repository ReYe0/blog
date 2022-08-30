package com.study.controller.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.common.CommonResult;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.entity.dto.BlogResponseDTO;
import com.study.entity.vo.BlogListVo;
import com.study.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: blog
 * 博客curd
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/8/11 10:30
 */
@RestController
@RequestMapping("/blog")
public class BlogControllerImpl implements com.study.controller.BlogController {
    @Autowired
    private BlogService blogService;

    @Override
    public CommonResult saveOrUpdate(Blog blog) {
        return CommonResult.success(blogService.saveOrUpdate(blog));
    }

    @Override
    public CommonResult<BlogResponseDTO> getBlogList(BlogQueryDTO blogQueryDTO) {
        IPage<BlogListVo> vo = blogService.getBlogList(blogQueryDTO);
        BlogResponseDTO res = new BlogResponseDTO();
        res.setBlogList(vo.getRecords());
        res.setTotal(vo.getTotal());
        return CommonResult.success(res);
    }
}

