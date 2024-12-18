package com.study.blog.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPageBackReqDTO {
    private Integer pageNum = 1;

//    @Range(min = 1, max = 40, message = "每页条目数只能在 1-40 之间")
    private Integer pageSize = 10;
    private String blogTypeId;
    private String categoryId;
    private String tagId;
    private String title;
}
