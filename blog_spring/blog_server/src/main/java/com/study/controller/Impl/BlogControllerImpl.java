package com.study.controller.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.common.BeanCopyUtils;
import com.study.common.CommonResult;
import com.study.entity.Blog;
import com.study.entity.BlogTag;
import com.study.entity.dto.BlogEditReqDTO;
import com.study.entity.dto.BlogEditResDTO;
import com.study.entity.dto.BlogPageReqDTO;
import com.study.entity.dto.BlogPageResDTO;
import com.study.entity.vo.BlogListVo;
import com.study.mapper.BlogTagMapper;
import com.study.service.BlogService;
import com.study.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogControllerImpl implements com.study.controller.BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogTagMapper blogTagMapper;
    @Override
    public CommonResult saveOrUpdate(BlogEditReqDTO blogEditReqDTO) {
        List<String> urls = StringUtils.getUrls(blogEditReqDTO.getContent());
        if (urls.size() != 0){
            blogEditReqDTO.setThumbnail(urls.get(0));
        }
        Blog blog = BeanCopyUtils.copyBean(blogEditReqDTO, Blog.class);
        if(blogService.saveOrUpdate(blog)){
            BlogEditResDTO blogEditResDTO = BeanCopyUtils.copyBean(blog, BlogEditResDTO.class);
            List<Integer> tags = blogEditReqDTO.getTags();
            QueryWrapper<BlogTag> wrapper = new QueryWrapper<>();
            wrapper.eq("blog_id",blog.getId());
            List<BlogTag> blogTags = blogTagMapper.selectList(wrapper);
            for (int i = 0; i < tags.size(); i++) {
//                if(tags.contains()){
                    blogTagMapper.insert(new BlogTag(null,blog.getId(), tags.get(i).longValue()));
//                }
            }
            blogEditResDTO.setTags(tags);
            return CommonResult.success(blogEditResDTO);
        }else{
            return CommonResult.error();
        }
    }

    @Override
    public CommonResult<BlogPageResDTO> getBlogList(BlogPageReqDTO blogPageReqDTO) {
        IPage<BlogListVo> vo = blogService.getBlogList(blogPageReqDTO);
        BlogPageResDTO res = new BlogPageResDTO();
        res.setBlogList(vo.getRecords());
        res.setTotal(vo.getTotal());
        return CommonResult.success(res);
    }
}

