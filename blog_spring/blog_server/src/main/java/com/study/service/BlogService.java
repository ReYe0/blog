package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.Blog;
import com.study.entity.dto.BlogDetailDTO;
import com.study.entity.dto.BlogEditResDTO;
import com.study.entity.dto.BlogPageBackReqDTO;
import com.study.entity.dto.BlogPageReqDTO;
import com.study.entity.vo.BlogBackListVo;
import com.study.entity.vo.BlogListVo;
import com.study.entity.vo.HotBlogVo;

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
     * @param blogPageReqDTO
     * @return
     */
    public IPage<BlogListVo> getBlogList(BlogPageReqDTO blogPageReqDTO);

    /**
     * 获取后台文章信息分页
     * @param blogPageBackReqDTO
     * @return
     */
    public IPage<BlogBackListVo> getBlogBackList(BlogPageBackReqDTO blogPageBackReqDTO);

    /**
     * 获取文章详情
     * @author 二爷
     * @E-mail 1299461580@qq.com
     * @date 2022/9/7 16:30
     * @param  id
     * @return com.study.entity.Blog
     */
    public BlogDetailDTO getBlogDetail(Long id);

    public Integer changeStatus(Long id);

    public Integer changeIsTop(Long id);

    public BlogEditResDTO getBlogEdit(Long id);

    public List<HotBlogVo> getHotBlogList();
}
