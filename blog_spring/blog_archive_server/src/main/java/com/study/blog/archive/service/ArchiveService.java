package com.study.blog.archive.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.blog.archive.vo.ArchiveCountVo;
import com.study.blog.archive.vo.ArchiveVo;
import com.study.blog.entity.vo.PageVo;

import java.util.List;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 19:24
 */
public interface ArchiveService extends IService<ArchiveCountVo> {
    List<ArchiveCountVo> getArchiveCountList(Integer pageNum, Integer pageSize);
    PageVo<ArchiveVo> getArchiveList(Integer pageNum, Integer pageSize);
}
