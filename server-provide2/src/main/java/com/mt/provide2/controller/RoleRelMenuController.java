package com.mt.provide2.controller;

import com.mt.common.entity.sys.RoleRelMenuEntity;
import com.mt.common.http.HttpResult;
import com.mt.provide2.service.RoleRelMenuService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: motb
 * @date: 2020/4/14 16:43
 * @description:
 */
@Api(tags = "系统-角色菜单")
@RestController
@RequestMapping("/sys/role/menu")
@AllArgsConstructor
public class RoleRelMenuController {

    private RoleRelMenuService roleRelMenuService;

    @GetMapping("/{roleId}")
    public HttpResult get(@PathVariable Long roleId) {
        Example example = new Example(RoleRelMenuEntity.class);
        example.and().andEqualTo("roleId", roleId);
        return HttpResult.success(roleRelMenuService.listByExample(example));
    }

    @PostMapping("/{roleId}")
    public HttpResult save(@PathVariable Long roleId, @RequestBody List<Long> menuIds) {
        RoleRelMenuEntity relMenuEntity = new RoleRelMenuEntity();
        relMenuEntity.setRoleId(roleId);
        roleRelMenuService.getBaseMapper().delete(relMenuEntity);
        if (!CollectionUtils.isEmpty(menuIds)) {
            List<RoleRelMenuEntity> relMenuEntityList = menuIds.stream().map(menuId -> {
                RoleRelMenuEntity item = new RoleRelMenuEntity();
                item.setRoleId(roleId);
                item.setMenuId(menuId);
                return item;
            }).collect(Collectors.toList());
            roleRelMenuService.saveList(relMenuEntityList);
        }
        return HttpResult.success();
    }
}
