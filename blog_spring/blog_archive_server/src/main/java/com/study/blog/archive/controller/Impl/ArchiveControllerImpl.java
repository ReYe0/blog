package com.study.blog.archive.controller.Impl;

import com.study.blog.archive.controller.ArchiveController;
import com.study.blog.archive.service.ArchiveService;
import com.study.blog.archive.vo.ArchiveVo;
import com.study.blog.common.CommonResult;
import com.study.blog.entity.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Override
    public CommonResult getArchiveCountList(Integer pageNum, Integer pageSize) {
        return CommonResult.success(archiveService.getArchiveCountList(pageNum,pageSize));
    }
    @Override
    public CommonResult getArchiveList(Integer pageNum, Integer pageSize) {
        PageVo<ArchiveVo> archiveList = archiveService.getArchiveList(pageNum, pageSize);
        ServiceInstance serviceInstance = loadBalancerClient.choose("blog-server");
        System.out.println("负载均衡调用："+serviceInstance.getHost() +serviceInstance.getPort());
        return CommonResult.success(archiveList);
    }
}
