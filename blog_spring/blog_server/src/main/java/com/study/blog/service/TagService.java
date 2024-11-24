package com.study.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.blog.entity.Tag;
import com.study.blog.entity.vo.TagListVo;

import java.util.List;

public interface TagService extends IService<Tag> {
    public List<TagListVo> getTagList();
}
