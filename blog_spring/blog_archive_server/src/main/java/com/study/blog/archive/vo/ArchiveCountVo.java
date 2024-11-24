package com.study.archive.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 19:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveCountVo {
    private String date;
    private Integer count;
}
