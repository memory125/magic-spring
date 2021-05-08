package com.wing.controller;

import com.wing.config.MinioConfig;
import com.wing.utils.MinioUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/minio")
@Api(tags = {"MinIO测试接口"})
public class MinioController {
    @Autowired
    MinioConfig minioConfig;

    @ApiOperation(value = "上传文件")
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        String fileUrl = MinioUtil.upload(minioConfig.getBucketName(), file);
        return "文件下载地址：" + fileUrl;
    }

    @ApiOperation(value = "下载文件")
    @GetMapping(value = "/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        MinioUtil.download(minioConfig.getBucketName(), fileName, response);
    }

    @ApiOperation(value = "删除文件")
    @GetMapping(value = "/delete")
    public String delete(@RequestParam("fileName") String fileName) {
        MinioUtil.deleteFile(minioConfig.getBucketName(), fileName);
        return "删除成功";
    }
}
