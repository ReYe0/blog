package com.study.blog.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 17:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreviousNextBlogVo {
    private HotBlogVo previous;
    private HotBlogVo next;
}
