package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_category")
public class Category {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("pid")
    private Integer pid;
    @TableField("description")
    private String description;
    @TableField("status")
    private String status;
    @TableField("create_by")
    private Long createBy;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_by")
    private Long updateBy;
    @TableField("del_flag")
    private Integer delFlag;
}
