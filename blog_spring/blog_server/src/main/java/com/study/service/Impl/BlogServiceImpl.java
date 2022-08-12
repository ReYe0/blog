package com.study.service.Impl;

import com.study.entity.Blog;
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
        blog.setDescription("hhhh");
        blog.setViews(1);
        blog.setWords(12);
        blog.setTypeId(1l);
        List<String> urls = StringUtils.getUrls(blog.getContent());
        if (urls.size() != 0){
            blog.setFirstPicture(urls.get(0));
        }
        if(blog.getId() != null){
            blogMapper.updateById(blog);
        }else{
            blogMapper.insert(blog);
        }
        return blog;
    }
}
