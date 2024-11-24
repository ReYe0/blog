package com.study.blog.entity.dto;

import com.study.blog.entity.vo.BlogBackListVo;
import lombok.Data;

import java.util.List;

@Data
public class BlogPageBackResDTO {
    private List<BlogBackListVo> blogList;
    private Long total;
}
