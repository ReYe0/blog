package com.study.blog.archive.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.blog.archive.feign.BlogClient;
import com.study.blog.archive.mapper.ArchiveMapper;
import com.study.blog.archive.mapper.ArchiveVoMapper;
import com.study.blog.archive.service.ArchiveService;
import com.study.blog.archive.vo.ArchiveCountVo;
import com.study.blog.archive.vo.ArchiveVo;
import com.study.blog.entity.vo.HotBlogVo;
import com.study.blog.common.BeanCopyUtils;
import com.study.blog.entity.Blog;
import com.study.blog.entity.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 19:26
 */
@Service
public class ArchiveServiceImpl extends ServiceImpl<ArchiveMapper, ArchiveCountVo> implements ArchiveService {
    @Autowired
    private ArchiveMapper archiveMapper;
    @Autowired
    private BlogClient blogClient;
    @Autowired
    private ArchiveVoMapper archiveVoMapper;
    @Override
    public List<ArchiveCountVo> getArchiveCountList(Integer pageNum, Integer pageSize) {
//        Long total = archiveMapper.selectArchiveTotalCount();
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
        PageVo<ArchiveVo> archiveVoPageVo = new PageVo<>(blogClient.getNormalBlogCount(), archiveVos);
        return archiveVoPageVo;
    }
}
