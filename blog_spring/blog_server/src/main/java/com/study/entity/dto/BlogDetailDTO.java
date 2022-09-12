package com.study.entity.dto;

import com.study.entity.BlogTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDetailDTO {
    private Long id;
    private String title;
    private String thumbnail;
    private String summary;
    private String content;
    private Long viewCount;
    private Long categoryId;
    private String categoryName;
    private Date createTime;
    private List<BlogTag> tags;
}
