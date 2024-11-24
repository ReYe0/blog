package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/11 17:52
 */

@Data
@TableName("tb_blog_type")
public class BlogType
{
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField("blog_type")
    private String blogType;
}
