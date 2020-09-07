package com.mt.api.middle.feign;

import com.mt.common.core.SystemConst;
import com.mt.common.entity.middle.FileEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author motb
 * @date 2020/7/22 14:35
 * @description
 */
@Api(tags = "文件管理")
@FeignClient(path = SystemConst.ServerConfig.MT_CLOUD_MIDDLE_FILE, name = SystemConst.ServerConfig.MT_CLOUD_MIDDLE)
public interface FileApi {

    @ApiOperation("批量插入")
    @PostMapping
    HttpResult save(@RequestBody List<FileEntity> fileEntityList);

    @ApiOperation("批量删除")
    @DeleteMapping
    HttpResult batchDelete(@RequestBody List<Long> ids);

    @ApiOperation("上传文件")
    @PostMapping("/upload/{bucketName}")
    HttpResult uploadFile(@RequestParam(value = "file") MultipartFile file,
                          @PathVariable("bucketName") String bucketName,
                          @RequestParam(value = "isRename", defaultValue = "0") String isRename) throws Exception;

    @ApiOperation("文件下载")
    @GetMapping("/download/{bucketName}/{fileName}")
    void downloadFile(@PathVariable("bucketName") String bucketName,
                      @PathVariable("fileName") String fileName,
                      HttpServletResponse response) throws Exception;
}
