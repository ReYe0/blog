package com.study.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveVo {
    private Integer year;
    private List<HotBlogVo> blogs;
}
