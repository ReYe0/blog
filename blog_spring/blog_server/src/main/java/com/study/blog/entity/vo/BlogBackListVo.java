package com.study.blog.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BlogBackListVo {
    private Long id;
    //标题
    private String title;

    //所属分类名
    private String categoryName;
    //缩略图
    private String thumbnail;


    //访问量
    private Long viewCount;
    private String blogType;
    private Boolean isTop;
    private Boolean status;
    private Date createTime;
}
