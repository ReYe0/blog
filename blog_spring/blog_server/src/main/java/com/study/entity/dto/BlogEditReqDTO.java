package com.study.entity.dto;

import com.study.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEditReqDTO {
    private Long id;
    private String title;
    private String thumbnail;
    private String summary;
    private String content;
    private Long categoryId;
    private List<Integer> tags;
}
