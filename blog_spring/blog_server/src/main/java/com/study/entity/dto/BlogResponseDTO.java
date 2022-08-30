package com.study.entity.dto;

import com.study.entity.vo.BlogListVo;
import lombok.Data;

import java.util.List;

@Data
public class BlogResponseDTO {
    private List<BlogListVo> blogList;
    private Long total;
}
