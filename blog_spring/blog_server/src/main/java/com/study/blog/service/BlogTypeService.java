package com.study.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.blog.entity.BlogType;

import java.util.List;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/11 18:15
 */
public interface BlogTypeService extends IService<BlogType> {
    public List getBlogTypeList();
}
