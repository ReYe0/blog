package com.study.archive.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.vo.ArchiveCountVo;
import com.study.entity.vo.ArchiveVo;
import com.study.entity.vo.PageVo;

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
