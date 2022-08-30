package com.study.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.entity.vo.BlogListVo;
import com.study.mapper.BlogMapper;
import com.study.service.BlogService;
import com.study.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Blog saveOrUpdate(Blog blog) {
        blog.setSummary("hhhh");
        blog.setViewCount(1l);
        blog.setWords(12);
        blog.setCategoryId(1l);
        List<String> urls = StringUtils.getUrls(blog.getContent());
        if (urls.size() != 0){
            blog.setThumbnail(urls.get(0));
        }
        if(blog.getId() != null){
            blogMapper.updateById(blog);
        }else{
            blogMapper.insert(blog);
        }
        return blog;
    }

    @Override
    public List<BlogListVo> getBlogList(BlogQueryDTO blogQueryDTO) {
        Page<BlogListVo> Page = new Page<BlogListVo>(blogQueryDTO.getPageNum(), blogQueryDTO.getPageSize());
        return blogMapper.getBlogListVo(Page).getRecords();
    }
}
