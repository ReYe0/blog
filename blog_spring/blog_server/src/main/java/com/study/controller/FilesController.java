package com.study.controller;

import com.study.common.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FilesController {
    @PostMapping(value = "/upload",name = "文件上传接口")
    public CommonResult upload(@RequestParam MultipartFile file) throws IOException;
}
