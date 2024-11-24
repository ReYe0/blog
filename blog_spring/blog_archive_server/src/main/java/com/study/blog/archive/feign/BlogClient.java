package com.study.blog.archive.feign;

import com.study.blog.archive.fallback.BlogClientFallbackFactory;
import com.study.blog.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: blog_spring
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/11/11 12:35
 */
@FeignClient(name = "blog-server",
fallbackFactory = BlogClientFallbackFactory.class)
public interface BlogClient {
    @GetMapping("/blog/getNormalBlogCount")
    public Long getNormalBlogCount();
}
