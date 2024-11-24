package com.study.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import com.study.entity.vo.HotBlogVo;
import com.study.entity.vo.PreviousNextBlogVo;
import com.study.enums.AppHttpCodeEnum;
import com.study.mapper.BlogMapper;
import com.study.mapper.BlogTagMapper;
import com.study.service.BlogService;
import com.study.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper,Blog> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogTagMapper blogTagMapper;
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
        if(blogPageReqDTO.getCategoryId() == null && blogPageReqDTO.getTagId() == null && blogPageReqDTO.getDate() ==null){
            return blogMapper.getBlogListVo(mapPage,SystemConstants.BLOG_STATUS_NORMAL);
        }else if(blogPageReqDTO.getCategoryId() != null){
            return blogMapper.getBlogCategoryListVo(mapPage,SystemConstants.BLOG_STATUS_NORMAL,blogPageReqDTO.getCategoryId());
        }else if(blogPageReqDTO.getTagId() != null){
            return blogMapper.getBlogTagListVo(mapPage,SystemConstants.BLOG_STATUS_NORMAL,blogPageReqDTO.getTagId());
        }else{
            return blogMapper.getBlogDateListVo(mapPage,SystemConstants.BLOG_STATUS_NORMAL,blogPageReqDTO.getDate().split("/")[0],blogPageReqDTO.getDate().split("/")[1]);
        }
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

    @Override
    public List<HotBlogVo> getHotBlogList() {
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getStatus, SystemConstants.BLOG_STATUS_NORMAL);
        wrapper.orderByDesc(Blog::getViewCount);
        // wrapper.last("limit 5");

        Page<Blog> page = new Page<>(1, 5);
//        this.page(page, wrapper);
        Page<Blog> blogPage = blogMapper.selectPage(page, wrapper);
        List<Blog> records = blogPage.getRecords();
        return BeanCopyUtils.copyBeanList(records,HotBlogVo.class);
    }

    @Override
    public PreviousNextBlogVo getPreviousNextBlog(Long id) {
        // 查询当前的文章
        Blog blog = getById(id);
        Assert.notNull(blog, AppHttpCodeEnum.RESOURCE_NOT_EXIST);
        PreviousNextBlogVo previousNextBlogVo = new PreviousNextBlogVo();

        // 查询上一篇文章
        QueryWrapper<Blog> previousWrapper = new QueryWrapper<>();
        previousWrapper.lt("create_time", blog.getCreateTime());
        previousWrapper.orderByDesc("create_time").last("limit 1");
        Blog previousBlog = getOne(previousWrapper);
        if (previousBlog!= null) {
            previousNextBlogVo.setPrevious(BeanCopyUtils.copyBean(previousBlog, HotBlogVo.class));
        }

        // 查询下一篇文章
        QueryWrapper<Blog> nextWrapper = new QueryWrapper<>();
        nextWrapper.gt("create_time", blog.getCreateTime());
        nextWrapper.orderByAsc("create_time").last("limit 1");
        Blog nextBlog = getOne(nextWrapper);
        if (nextBlog != null) {
            previousNextBlogVo.setNext(BeanCopyUtils.copyBean(nextBlog, HotBlogVo.class));
        }
        return previousNextBlogVo;
    }

    @Override
    public Long getNormalBlogCount() {
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getStatus, SystemConstants.BLOG_STATUS_NORMAL);
         return Long.valueOf(blogMapper.selectCount(wrapper));
//        return count(wrapper);
    }
}
