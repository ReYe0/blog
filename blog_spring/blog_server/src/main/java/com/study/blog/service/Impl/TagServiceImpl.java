package com.study.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.blog.common.BeanCopyUtils;
import com.study.blog.entity.Tag;
import com.study.blog.entity.vo.TagListVo;
import com.study.blog.mapper.TagMapper;
import com.study.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<TagListVo> getTagList() {
        List<Tag> tagList = tagMapper.selectList(null);
        return BeanCopyUtils.copyBeanList(tagList, TagListVo.class);
    }
}
