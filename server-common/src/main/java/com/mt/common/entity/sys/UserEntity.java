package com.mt.common.entity.sys;

import com.mt.common.core.MTEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author motb
 * @date 2020/3/25 20:42
 * @description:
 */
@Data
@ApiModel(value = "用户实体")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends MTEntity {

    private String name;

    private String account;

    private String password;
}
