package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.Blog;
import com.study.entity.dto.BlogQueryDTO;
import com.study.entity.vo.BlogListVo;

import java.util.List;

public interface BlogService extends IService<Blog> {

    /**
     * 更新和保存 blog
     * @param blog
     * @return
     */
//    public Blog saveOrUpdate(Blog blog);

    /**
     * 获取首页文章信息分页
     * @param blogQueryDTO
     * @return
     */
    public IPage<BlogListVo> getBlogList(BlogQueryDTO blogQueryDTO);
}
