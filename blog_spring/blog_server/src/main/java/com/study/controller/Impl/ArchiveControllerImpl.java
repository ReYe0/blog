package com.study.controller.Impl;

import com.study.common.CommonResult;
import com.study.controller.ArchiveController;
import com.study.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 19:13
 */
@RestController
@RequestMapping("/archive")
public class ArchiveControllerImpl implements ArchiveController {
    @Autowired
    private ArchiveService archiveService;
    @Override
    public CommonResult getArchiveCountList(Integer pageNum, Integer pageSize) {
        return CommonResult.success(archiveService.getArchiveCountList(pageNum,pageSize));
    }

    @Override
    public CommonResult getArchiveList(Integer pageNum, Integer pageSize) {

        return CommonResult.success(archiveService.getArchiveList(pageNum, pageSize));
    }
}
