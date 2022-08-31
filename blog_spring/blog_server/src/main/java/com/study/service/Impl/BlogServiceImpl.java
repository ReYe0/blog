package com.study.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.common.SystemConstants;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.entity.dto.BlogResponseDTO;
import com.study.entity.vo.BlogListVo;
import com.study.mapper.BlogMapper;
import com.study.service.BlogService;
import com.study.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public IPage<BlogListVo> getBlogList(BlogQueryDTO blogQueryDTO) {
//        LambdaQueryWrapper<BlogListVo> wrapper = Wrappers.lambdaQuery();
        Page<BlogListVo> mapPage = new Page<>(blogQueryDTO.getPageNum(), blogQueryDTO.getPageSize() );
        return blogMapper.getBlogListVo(mapPage,SystemConstants.BLOG_STATUS_NORMAL);
    }
}
