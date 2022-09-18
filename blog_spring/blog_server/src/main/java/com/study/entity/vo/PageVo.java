package com.study.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 19:49
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo<T> {
    private Long total;
    private List<T> rows;
}
