package com.mt.base.controller;

import com.mt.base.service.FileService;
import com.mt.base.service.MinioOssService;
import com.mt.common.entity.base.FileEntity;
import com.mt.common.http.HttpResult;
import io.minio.errors.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

/**
 * @auther: motb
 * @date: 2020/4/27 17:02
 * @description:
 */
@Api(tags = "系统-文件管理")
@RestController
@RequestMapping("/sys/file")
@AllArgsConstructor
public class FileController {

    private FileService fileService;

    private MinioOssService minioOssService;

    @ApiOperation("批量插入")
    @PostMapping
    public HttpResult save(@RequestBody List<FileEntity> fileEntityList) {
        fileService.saveList(fileEntityList);
        return HttpResult.success();
    }

    @ApiOperation("批量删除")
    @DeleteMapping
    public HttpResult batchDelete(@RequestBody List<Long> ids) {
        fileService.batchDelete(ids);
        return HttpResult.success();
    }

    @ApiOperation("上传文件")
    @PostMapping("/upload/{bucketName}")
    public HttpResult uploadFile(@RequestParam("file") MultipartFile file,
                                 @PathVariable("bucketName") String bucketName,
                                 @RequestParam(defaultValue = "0") String isRename) throws IOException, InvalidResponseException, RegionConflictException, InvalidKeyException, NoSuchAlgorithmException, ErrorResponseException, XmlParserException, InvalidBucketNameException, InsufficientDataException, InternalException {
        return HttpResult.success(minioOssService.putObject(bucketName, file, isRename));
    }

    @ApiOperation("文件下载")
    @GetMapping("/download/{bucketName}/{fileName}")
    public void downloadFile(@PathVariable("bucketName") String bucketName, @PathVariable("fileName") String fileName, HttpServletResponse response) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, ErrorResponseException, XmlParserException, InvalidBucketNameException, InsufficientDataException, InternalException {
        Optional<InputStream> fi = this.minioOssService.getObject(bucketName, fileName);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", new String(fileName.getBytes("UTF-8"), "ISO-8859-1")));
        response.setContentType("application/octet-stream;charset=UTF-8");
        if (fi.isPresent()) {
            try (InputStream in = fi.get();
                 ServletOutputStream out = response.getOutputStream()) {
                byte[] buffer = StreamUtils.copyToByteArray(in);
                response.setContentLength(buffer.length);
                StreamUtils.copy(buffer, out);
            }
        }
    }
}
