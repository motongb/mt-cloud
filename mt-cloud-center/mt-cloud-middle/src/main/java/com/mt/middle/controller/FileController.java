package com.mt.middle.controller;

import com.mt.api.middle.feign.FileApi;
import com.mt.common.core.SystemConst;
import com.mt.common.entity.middle.FileEntity;
import com.mt.common.http.HttpResult;
import com.mt.middle.service.MinioOssService;
import com.mt.middle.service.impl.FileServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

/**
 * @author motb
 * @date 2020/4/27 17:02
 * @description
 */

@RestController
@RequestMapping(SystemConst.ServerConfig.MT_CLOUD_MIDDLE_FILE)
@AllArgsConstructor
public class FileController implements FileApi {

    private FileServiceImpl fileService;

    private MinioOssService minioOssService;

    @Override
    public HttpResult save(List<FileEntity> fileEntityList) {
        fileService.getBaseMapper().insertList(fileEntityList);
        return HttpResult.success();
    }

    @Override
    public HttpResult batchDelete(List<Long> ids) {
        fileService.batchDelete(ids);
        return HttpResult.success();
    }

    @Override
    public HttpResult uploadFile(MultipartFile file, String bucketName, String isRename) throws Exception {
        return HttpResult.success(minioOssService.putObject(bucketName, file, isRename));
    }

    @Override
    public void downloadFile(String bucketName, String fileName, HttpServletResponse response) throws Exception {
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
