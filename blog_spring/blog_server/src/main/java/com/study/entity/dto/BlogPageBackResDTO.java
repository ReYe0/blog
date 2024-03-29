package com.study.entity.dto;

import com.study.entity.vo.BlogBackListVo;
import com.study.entity.vo.BlogListVo;
import lombok.Data;

import java.util.List;

@Data
public class BlogPageBackResDTO {
    private List<BlogBackListVo> blogList;
    private Long total;
}
