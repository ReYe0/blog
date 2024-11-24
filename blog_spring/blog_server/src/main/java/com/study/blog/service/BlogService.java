package com.study.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.blog.entity.Blog;
import com.study.blog.entity.dto.BlogDetailDTO;
import com.study.blog.entity.dto.BlogEditResDTO;
import com.study.blog.entity.dto.BlogPageBackReqDTO;
import com.study.blog.entity.dto.BlogPageReqDTO;
import com.study.blog.entity.vo.BlogBackListVo;
import com.study.blog.entity.vo.BlogListVo;
import com.study.blog.entity.vo.HotBlogVo;
import com.study.blog.entity.vo.PreviousNextBlogVo;

import java.util.List; // 配置要按自定义的类FeignClientConfig
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

    public PreviousNextBlogVo getPreviousNextBlog(Long id);

    public Long getNormalBlogCount();
}
