package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.FileUploadService;
import io.minio.*;
import io.minio.errors.MinioException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@RestController
@RequestMapping("/admin/product")
public class FileUpLoadController {

    @Autowired
    FileUploadService fileUploadService;


    @PostMapping("/fileUpload")
    public Result fileUpload(MultipartFile file){
        String url = fileUploadService.fileUpload(file);
        return Result.ok(url);
    }
}
