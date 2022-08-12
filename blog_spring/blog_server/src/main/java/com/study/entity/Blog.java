package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("tb_blog")
public class Blog {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField("title")
    private String title;
    @TableField("first_picture")
    private String firstPicture;
    @TableField("description")
    private String description;
    @TableField("content")
    private String content;
    @TableField("create_time")
    private LocalDateTime createTime;
    @TableField("update_time")
    private LocalDateTime updateTime;
    @TableField("views")
    private Integer views;
    @TableField("words")
    private Integer words;
    @TableField("type_id")
    private Long typeId;
    @TableField("user_id")
    private Long userId;
    @TableField("status")
    private Integer status;

}
