package com.study.blog.entity.dto;

import com.study.blog.entity.vo.BlogListVo;
import lombok.Data;

import java.util.List;

@Data
public class BlogPageResDTO {
    private List<BlogListVo> blogList;
    private Long total;
}
