package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.Tag;
import com.study.entity.vo.TagListVo;

import java.util.List;

public interface TagService extends IService<Tag> {
    public List<TagListVo> getTagList();
}
