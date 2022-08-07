package com.study.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.common.CommonResult;
import com.study.entity.Files;
import com.study.mapper.FilesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description: blog
 * 文件上传相关接口
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/8/7 20:00
 */
@RestController
@RequestMapping("/file")
public class FilesController {
    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Resource
    private FilesMapper filesMapper;

    @PostMapping(value = "/upload")
    public CommonResult upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();
        //        定义一个文件唯一的标识码
        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID = uuid + StrUtil.DOT + type;


        File uploadFile = new File(fileUploadPath +fileUUID);
        //判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        if(!uploadFile.getParentFile().exists()){
            uploadFile.getParentFile().mkdirs();
        }
        String url;
        //获取文件的md5
        String md5 = SecureUtil.md5(file.getInputStream());

        QueryWrapper<Files> filesQueryWrapper = new QueryWrapper<>();
        filesQueryWrapper.eq("md5", md5);
        List<Files> dbFiles = filesMapper.selectList(filesQueryWrapper);
        //当文件存在的时候在获取文件的md5
        if(uploadFile.exists()){
            //获取文件的md5,通过对比md5 避免相同的文件上传
            md5 = SecureUtil.md5(uploadFile);

            //        获取文件的url
            if(dbFiles.size() != 0){
                Files firstFile = dbFiles.get(0);
                url = firstFile.getUrl();
            }else {
//        把获取到的文件存储到磁盘目录
//                file.transferTo(uploadFile);
                url =  "http://localhost:8090/blog/file/" + fileUUID;
            }
        }else{
            //把获取到的文件存入到磁盘目录
            file.transferTo(uploadFile);
            md5 = SecureUtil.md5(uploadFile);
            url =  "http://localhost:8090/blog/file/" + fileUUID;
        }



        //存储数据库
        Files saveFile = new Files();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size/1024);// 转为kb
        saveFile.setUrl(url);
        saveFile.setMd5(md5);
        filesMapper.insert(saveFile);
        return CommonResult.success(saveFile);
    }
}
