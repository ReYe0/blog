package com.study.blog.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotBlogVo {
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 发表时间
     */
    private LocalDateTime createTime;

    /**
     * 访问量
     */
    private Long viewCount;
}
