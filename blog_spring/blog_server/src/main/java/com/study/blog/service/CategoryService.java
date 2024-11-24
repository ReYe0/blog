package com.study.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.blog.entity.Category;
import com.study.blog.entity.vo.CategoryCountVo;
import com.study.blog.entity.vo.CategoryListVo;

import java.util.List;

public interface CategoryService extends IService<Category> {

    /**
     * 获取全部分类
     * @return
     */
    public List<CategoryListVo> getCategoryList();

    public List<CategoryCountVo> getCategoryCountList();
}
