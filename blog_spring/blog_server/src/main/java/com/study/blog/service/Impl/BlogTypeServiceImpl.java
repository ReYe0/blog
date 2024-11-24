package com.study.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.blog.entity.BlogType;
import com.study.blog.mapper.BlogTypeMapper;
import com.study.blog.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/11 18:16
 */
@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements BlogTypeService {
    @Autowired
    private BlogTypeMapper blogTypeMapper;
    @Override
    public List getBlogTypeList() {
        return blogTypeMapper.selectList(null);
    }
}
