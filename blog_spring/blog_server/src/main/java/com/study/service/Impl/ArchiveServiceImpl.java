package com.study.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.common.BeanCopyUtils;
import com.study.entity.Blog;
import com.study.entity.vo.ArchiveCountVo;
import com.study.entity.vo.ArchiveVo;
import com.study.entity.vo.HotBlogVo;
import com.study.entity.vo.PageVo;
import com.study.mapper.ArchiveMapper;
import com.study.mapper.ArchiveVoMapper;
import com.study.mapper.BlogMapper;
import com.study.service.ArchiveService;
import com.study.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 19:26
 */
@Service
public class ArchiveServiceImpl extends ServiceImpl<ArchiveMapper,ArchiveCountVo> implements ArchiveService {
    @Autowired
    private ArchiveMapper archiveMapper;
    @Autowired
    private BlogService blogService;
    @Resource
    private ArchiveVoMapper archiveVoMapper;
    @Override
    public List<ArchiveCountVo> getArchiveCountList(Integer pageNum, Integer pageSize) {
        Long total = archiveMapper.selectArchiveTotalCount();
        return archiveMapper.selectArchiveCount((pageNum - 1) * pageSize, pageSize);
    }

    @Override
    public PageVo<ArchiveVo> getArchiveList(Integer pageNum, Integer pageSize) {
        List<ArchiveVo> archiveVos = archiveVoMapper.selectYearList();
        List<Blog> blogs = archiveVoMapper.selectArchiveList((pageNum - 1) * pageSize, pageSize);
        for (int i = 0; i < archiveVos.size(); i++) {
            List<HotBlogVo> hotBlogVos = new ArrayList<>();
            for (int j = 0; j < blogs.size(); j++) {
                if(archiveVos.get(i).getYear() == blogs.get(j).getCreateTime().getYear()){
                    hotBlogVos.add(BeanCopyUtils.copyBean(blogs.get(j), HotBlogVo.class));
                }
            }
            archiveVos.get(i).setBlogs(hotBlogVos);
        }
        for (int i = 0; i < archiveVos.size(); i++) {
            if (archiveVos.get(i).getBlogs().isEmpty()){
                archiveVos.remove(i);
            }
        }
        PageVo<ArchiveVo> archiveVoPageVo = new PageVo<>(blogService.getNormalBlogCount(), archiveVos);
        return archiveVoPageVo;
    }
}
