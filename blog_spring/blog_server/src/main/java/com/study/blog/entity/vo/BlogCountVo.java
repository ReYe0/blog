package com.study.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 21:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogCountVo {
    private Long blog;
    private Integer category;
    private Integer tag;
}
