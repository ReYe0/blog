package com.study.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.entity.vo.BlogListVo;

import java.util.List;

public interface BlogService {

    /**
     * 更新和保存 blog
     * @param blog
     * @return
     */
    public Blog saveOrUpdate(Blog blog);

    /**
     * 获取首页文章信息列表
     * @param blogQueryDTO
     * @return
     */
    public List<BlogListVo> getBlogList(BlogQueryDTO blogQueryDTO);
}
