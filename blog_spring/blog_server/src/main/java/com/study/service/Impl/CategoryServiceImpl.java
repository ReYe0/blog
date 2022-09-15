package com.study.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.common.BeanCopyUtils;
import com.study.common.SystemConstants;
import com.study.entity.Category;
import com.study.entity.vo.CategoryListVo;
import com.study.mapper.CategoryMapper;
import com.study.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<CategoryListVo> getCategoryList() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("status", SystemConstants.Category_STATUS_NORMAL);
        List<Category> list = categoryMapper.selectList(wrapper);
        return BeanCopyUtils.copyBeanList(list, CategoryListVo.class);
    }
}