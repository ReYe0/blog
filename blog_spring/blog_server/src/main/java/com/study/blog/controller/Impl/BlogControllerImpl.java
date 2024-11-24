package com.study.controller.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.common.BeanCopyUtils;
import com.study.common.CommonResult;
import com.study.controller.BlogController;
import com.study.entity.Blog;
import com.study.entity.BlogTag;
import com.study.entity.Tag;
import com.study.entity.dto.*;
import com.study.entity.vo.BlogBackListVo;
import com.study.entity.vo.BlogCountVo;
import com.study.entity.vo.BlogListVo;
import com.study.mapper.BlogTagMapper;
import com.study.mapper.TagMapper;
import com.study.service.BlogService;
import com.study.service.CategoryService;
import com.study.service.TagService;
import com.study.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogControllerImpl implements BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogTagMapper blogTagMapper;

    @Autowired
    private TagMapper tagMapper;

    @Resource
    private TagService tagService;
    @Resource
    private CategoryService categoryService;
    @Override
    public CommonResult saveOrUpdate(BlogEditReqDTO blogEditReqDTO) {
        List<String> urls = StringUtils.getUrls(blogEditReqDTO.getContent());
        if (urls.size() != 0){
            blogEditReqDTO.setThumbnail(urls.get(0));
        }
        Blog blog = BeanCopyUtils.copyBean(blogEditReqDTO, Blog.class);
        blog.setWords(blogEditReqDTO.getContent().length());
        if(blogService.saveOrUpdate(blog)){
            BlogEditResDTO blogEditResDTO = BeanCopyUtils.copyBean(blog, BlogEditResDTO.class);
            List<Long> tags = blogEditReqDTO.getTags();
            QueryWrapper<BlogTag> wrapper = new QueryWrapper<>();
            wrapper.eq("blog_id",blog.getId());
            blogTagMapper.delete(wrapper);
            for (int i = 0; i < tags.size(); i++) {
                blogTagMapper.insert(new BlogTag(blogEditResDTO.getId(), tags.get(i)));
            }
            blogEditResDTO.setTags(tags);
            return CommonResult.success(blogEditResDTO);
        }else{
            return CommonResult.error();
        }
    }

    @Override
    public CommonResult getBlogEdit(Long id) {
        BlogEditResDTO blogEdit = blogService.getBlogEdit(id);
        QueryWrapper<BlogTag> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_id",blogEdit.getId());
        List<BlogTag> blogTags = blogTagMapper.selectList(wrapper);
        List<Long> tags = new ArrayList<>();
        for (int i = 0; i < blogTags.size(); i++) {
            tags.add(blogTags.get(i).getTagId());
        }
        blogEdit.setTags(tags);
        return CommonResult.success(blogEdit);
    }

    @Override
    public CommonResult<BlogPageResDTO> getBlogList(BlogPageReqDTO blogPageReqDTO) {
        IPage<BlogListVo> vo = blogService.getBlogList(blogPageReqDTO);
        BlogPageResDTO res = new BlogPageResDTO();
        res.setBlogList(vo.getRecords());
        res.setTotal(vo.getTotal());
        return CommonResult.success(res);
    }

    @Override
    public CommonResult<BlogPageBackResDTO> getBlogBackList(BlogPageBackReqDTO blogPageBackReqDTO) {
        IPage<BlogBackListVo> vo = blogService.getBlogBackList(blogPageBackReqDTO);
        BlogPageBackResDTO res = new BlogPageBackResDTO();
        res.setBlogList(vo.getRecords());
        res.setTotal(vo.getTotal());
        return CommonResult.success(res);
    }

    @Override
    public CommonResult<BlogDetailDTO> getBlogDetail(Long id) {
        BlogDetailDTO blogDetail = blogService.getBlogDetail(id);
        LambdaQueryWrapper<BlogTag> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BlogTag::getBlogId,blogDetail.getId());
        List<BlogTag> blogTags = blogTagMapper.selectList(wrapper);
        ArrayList<Tag> tags = new ArrayList<>();
        for (int i = 0; i < blogTags.size(); i++) {
            Tag tag = tagMapper.selectById(blogTags.get(i).getTagId());
            tags.add(tag);
        }
        blogDetail.setTags(tags);
        return CommonResult.success(blogDetail);
    }

    @Override
    public CommonResult changeStatus(Long id) {
        return CommonResult.success(blogService.changeStatus(id));
    }

    @Override
    public CommonResult changeIsTop(Long id) {
        return CommonResult.success(blogService.changeIsTop(id));
    }

    @Override
    public CommonResult getHotBlogList() {
        return CommonResult.success(blogService.getHotBlogList());
    }

    @Override
    public CommonResult getPreviousNextBlog(Long id) {
        return CommonResult.success(blogService.getPreviousNextBlog(id));
    }

    @Override
    public CommonResult getCount() {
        Long blog = blogService.getNormalBlogCount();
        int category = categoryService.count();
        int tag = tagService.count();
        return CommonResult.success(new BlogCountVo(blog,category,tag));
    }
}

