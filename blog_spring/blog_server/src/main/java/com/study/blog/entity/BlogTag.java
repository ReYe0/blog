package com.study.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_blog_tag")
public class BlogTag {
//    @TableId(value = "id",type = IdType.AUTO)
//    private Long id;
    @TableField("blog_id")
    private Long blogId;
    @TableField("tag_id")
    private Long tagId;
}
