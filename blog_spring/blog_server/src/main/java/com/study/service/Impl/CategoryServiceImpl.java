package com.study.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.common.BeanCopyUtils;
import com.study.common.SystemConstants;
import com.study.entity.Blog;
import com.study.entity.Category;
import com.study.entity.vo.CategoryCountVo;
import com.study.entity.vo.CategoryListVo;
import com.study.mapper.BlogMapper;
import com.study.mapper.CategoryMapper;
import com.study.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public List<CategoryListVo> getCategoryList() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("status", SystemConstants.Category_STATUS_NORMAL);
        List<Category> list = categoryMapper.selectList(wrapper);
        return BeanCopyUtils.copyBeanList(list, CategoryListVo.class);
    }

    @Override
    public List<CategoryCountVo> getCategoryCountList() {
        // 从数据库中查询非草稿的文章的目录 id
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getStatus, SystemConstants.BLOG_STATUS_NORMAL);
        List<Blog> blogList = blogMapper.selectList(wrapper);
//        Set<Long> categoryIds = articles.stream().map(Article::getCategoryId).collect(Collectors.toSet());
        return null;
    }
}
