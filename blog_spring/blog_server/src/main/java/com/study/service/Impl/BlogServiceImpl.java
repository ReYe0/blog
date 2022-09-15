package com.study.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.common.BeanCopyUtils;
import com.study.common.SystemConstants;
import com.study.entity.Blog;
import com.study.entity.dto.BlogDetailDTO;
import com.study.entity.dto.BlogEditResDTO;
import com.study.entity.dto.BlogPageBackReqDTO;
import com.study.entity.dto.BlogPageReqDTO;
import com.study.entity.vo.BlogBackListVo;
import com.study.entity.vo.BlogListVo;
import com.study.mapper.BlogMapper;
import com.study.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper,Blog> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

//    @Override
//    public Blog saveOrUpdate(Blog blog) {
//        blog.setSummary("hhhh");
//        blog.setViewCount(1l);
//        blog.setWords(12);
//        blog.setCategoryId(1l);
//        List<String> urls = StringUtils.getUrls(blog.getContent());
//        if (urls.size() != 0){
//            blog.setThumbnail(urls.get(0));
//        }
//        if(blog.getId() != null){
//            blogMapper.updateById(blog);
//        }else{
//            blogMapper.insert(blog);
//        }
//        return blog;
//    }

    @Override
    public IPage<BlogListVo> getBlogList(BlogPageReqDTO blogPageReqDTO) {
//        LambdaQueryWrapper<BlogListVo> wrapper = Wrappers.lambdaQuery();
//        LambdaQueryWrapper<BlogListVo> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Blog::getStatus,1)
        Page<BlogListVo> mapPage = new Page<>(blogPageReqDTO.getPageNum(), blogPageReqDTO.getPageSize() );
        return blogMapper.getBlogListVo(mapPage,SystemConstants.BLOG_STATUS_NORMAL);
    }

    @Override
    public IPage<BlogBackListVo> getBlogBackList(BlogPageBackReqDTO blogPageBackReqDTO) {
        Page<BlogBackListVo> mapPage = new Page<>(blogPageBackReqDTO.getPageNum(), blogPageBackReqDTO.getPageSize());
        return blogMapper.getBlogBackListVo(mapPage, blogPageBackReqDTO.getBlogTypeId(), blogPageBackReqDTO.getCategoryId(), blogPageBackReqDTO.getTagId(), blogPageBackReqDTO.getTitle());
    }

    @Override
    public BlogDetailDTO getBlogDetail(Long id) {
        Blog blog = blogMapper.selectById(id);
//        BlogEditResDTO blogEditResDTO = BeanCopyUtils.copyBean(blog, BlogEditResDTO.class);
        return BeanCopyUtils.copyBean(blog, BlogDetailDTO.class);
    }

    @Override
    public Integer changeStatus(Long id) {
        Blog blog = blogMapper.selectById(id);
        blog.setStatus(!blog.getStatus());
        return blogMapper.updateById(blog);
    }

    @Override
    public Integer changeIsTop(Long id) {
        Blog blog = blogMapper.selectById(id);
        blog.setIsTop(!blog.getIsTop());
        return blogMapper.updateById(blog);
    }

    @Override
    public BlogEditResDTO getBlogEdit(Long id) {
        Blog blog = blogMapper.selectById(id);
        return BeanCopyUtils.copyBean(blog, BlogEditResDTO.class);
    }
}
