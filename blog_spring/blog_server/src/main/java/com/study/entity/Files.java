package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/8/7 19:57
 */
@Data
@TableName("tb_files")
public class Files implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("type")
    private String type;
     @TableField("size")
    private Long size;
     @TableField("url")
    private String url;
     @TableField("is_delete")
    private Boolean isDelete;
     @TableField("enable")
    private Boolean enable;
     @TableField("md5")
    private String md5;
}