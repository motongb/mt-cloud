package com.mt.common.entity.sys;

import com.mt.common.core.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @author motb
 * @date 2020/3/25 20:42
 * @description:
 */
@Data
@Table(name = "sys_user")
@ApiModel(value = "用户实体")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    private String name;

    private String account;

    private String password;
}
