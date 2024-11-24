package com.study.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEditResDTO {
    private Long id;
    private String title;
    private String thumbnail;
    private String summary;
    private String content;
    private Long viewCount;
    private Boolean status;
    private Long blogType;
    private Long blogTypeId;
    private Long categoryId;
    private Date createTime;
    private List<Long> tags;
}
