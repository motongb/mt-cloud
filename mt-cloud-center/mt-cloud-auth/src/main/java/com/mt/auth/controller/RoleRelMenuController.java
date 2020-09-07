package com.mt.auth.controller;

import com.mt.auth.service.RoleRelMenuService;
import com.mt.common.entity.auth.RoleRelMenuEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author motb
 * @date 2020/4/14 16:43
 * @description
 */
@Api(tags = "系统-角色菜单")
@RestController
@RequestMapping("/sys/role/menu")
@AllArgsConstructor
public class RoleRelMenuController {

    private RoleRelMenuService roleRelMenuService;

    @GetMapping("/{roleId}")
    public HttpResult get(@PathVariable Long roleId) {
        return HttpResult.success(roleRelMenuService.getBaseMapper().selectByRoleId(roleId));
    }

    @PostMapping("/{roleId}")
    public HttpResult save(@PathVariable Long roleId, @RequestBody List<Long> menuIds) {
        RoleRelMenuEntity relMenuEntity = new RoleRelMenuEntity();
        relMenuEntity.setRoleId(roleId);
        roleRelMenuService.delete(relMenuEntity);
        if (!CollectionUtils.isEmpty(menuIds)) {
            List<RoleRelMenuEntity> relMenuEntityList = menuIds.stream().map(menuId -> {
                RoleRelMenuEntity item = new RoleRelMenuEntity();
                item.setRoleId(roleId);
                item.setMenuId(menuId);
                return item;
            }).collect(Collectors.toList());
            roleRelMenuService.getBaseMapper().insertList(relMenuEntityList);
        }
        return HttpResult.success();
    }
}
