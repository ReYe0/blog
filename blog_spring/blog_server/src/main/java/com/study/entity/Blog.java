package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.*;
import java.time.LocalDateTime;

@Data
@TableName("tb_blog")
public class Blog {
//public class Blog implements Serializable, Cloneable {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField("title")
    private String title;
    @TableField("thumbnail")
    private String thumbnail;
    @TableField("summary")
    private String summary;
    @TableField("content")
    private String content;
    @TableField("create_time")
    private LocalDateTime createTime;
    @TableField("update_time")
    private LocalDateTime updateTime;
    @TableField("view_count")
    private Long viewCount;
    @TableField("words")
    private Integer words;
    @TableField("category_id")
    private Long categoryId;
    @TableField("user_id")
    private Long userId;
    @TableField("status")
    private Boolean status;
    @TableField("is_top")
    private Boolean isTop;
    @TableField("del_flag")
    private Integer delFlag;
    @TableField("blog_type_id")
    private Long blogTypeId;

//    Files files;
//    public Blog  deepClone() throws IOException, ClassNotFoundException, OptionalDataException
//    {
//        //将对象写入流中
//        ByteArrayOutputStream bao=new  ByteArrayOutputStream();
//        ObjectOutputStream oos=new  ObjectOutputStream(bao);
//        oos.writeObject(this);
//
//        //将对象从流中取出
//        ByteArrayInputStream bis=new  ByteArrayInputStream(bao.toByteArray());
//        ObjectInputStream ois=new  ObjectInputStream(bis);
//        return (Blog) ois.readObject();
//    }
}
