package com.study.controller;

import com.study.common.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description: blog
 * 文件上传相关接口
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/8/7 20:00
 */
public interface FilesController {
    @PostMapping(value = "/upload",name = "文件上传接口")
    public CommonResult upload(@RequestParam MultipartFile file) throws IOException;
}
