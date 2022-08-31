package com.study.controller.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.common.CommonResult;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.entity.dto.BlogResponseDTO;
import com.study.entity.vo.BlogListVo;
import com.study.service.BlogService;
import com.study.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogControllerImpl implements com.study.controller.BlogController {
    @Autowired
    private BlogService blogService;

    @Override
    public CommonResult saveOrUpdate(Blog blog) {
        blog.setSummary("hhhh");
        blog.setViewCount(1l);
        blog.setWords(12);
        blog.setCategoryId(1l);
        List<String> urls = StringUtils.getUrls(blog.getContent());
        if (urls.size() != 0){
            blog.setThumbnail(urls.get(0));
        }
//        blogService.saveOrUpdate(blog);
//        if(blog.getId() != null){
//            blogMapper.updateById(blog);
//        }else{
//            blogMapper.insert(blog);
//        }
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

