package com.study.blog.archive.vo;

import com.study.blog.entity.vo.HotBlogVo;
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
