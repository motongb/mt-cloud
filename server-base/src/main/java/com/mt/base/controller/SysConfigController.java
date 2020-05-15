package com.mt.base.controller;

import com.mt.base.service.SysConfigService;
import com.mt.common.entity.base.SysConfigEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: motb
 * @date: 2020/5/14 14:54
 * @description:
 */
@Api(tags = "系统-配置管理")
@RestController
@RequestMapping("/sys/config")
@AllArgsConstructor
public class SysConfigController {

    private SysConfigService sysConfigService;

    @GetMapping
    public HttpResult get() {
        return HttpResult.success(sysConfigService.getBaseMapper().selectAll());
    }

    @PutMapping
    public HttpResult update(@RequestBody SysConfigEntity sysConfigEntity) {
        sysConfigService.update(sysConfigEntity);
        return HttpResult.success();
    }
}
