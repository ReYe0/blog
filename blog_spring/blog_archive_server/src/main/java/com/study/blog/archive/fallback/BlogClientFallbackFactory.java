package com.study.blog.archive.fallback;

import com.study.blog.archive.feign.BlogClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: blog_spring
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/11/11 18:10
 */
@Component
public class BlogClientFallbackFactory implements FallbackFactory<BlogClient> {
    @Override
    public BlogClient create(Throwable throwable) {
        new BlogClient() {
            @Override
            public Long getNormalBlogCount() {
                return null;
            }
        };
        return null;
    }
}
