package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.Category;
import com.study.entity.vo.CategoryListVo;

import java.util.List;

public interface CategoryService extends IService<Category> {

    /**
     * 获取全部分类
     * @return
     */
    public List<CategoryListVo> getCategoryList();
}
