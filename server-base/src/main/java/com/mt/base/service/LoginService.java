package com.mt.base.service;

import com.mt.common.core.CodeEnum;
import com.mt.common.entity.base.UserEntity;
import com.mt.common.entity.base.vo.LoginInfo;
import com.mt.common.exception.SysException;
import com.mt.common.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author motb
 * @date 2020/3/25 21:51
 * @description:
 */
@Service
@AllArgsConstructor
public class LoginService {

    private UserService userService;

    private UserRelRoleService userRelRoleService;

    public Map<String, Object> login(LoginInfo loginInfo) {
        UserEntity query = new UserEntity();
        query.setAccount(loginInfo.getAccount());
        UserEntity userEntity = userService.getBaseMapper().selectOne(query);
        //账号不存在
        if (userEntity == null) {
            throw new SysException(CodeEnum.ACCOUNT_NOT_EXITS);
        }
        //密码错误
        String pwd = loginInfo.getPassword();
        if (!DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(userEntity.getPassword())) {
            throw new SysException(CodeEnum.PASSWORD_ERROR);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("token", JwtUtils.createJwt(userEntity));
        result.put("menuList", userRelRoleService.getMenu(userEntity));
        result.put("access", userRelRoleService.getAccess(userEntity));
        return result;
    }
}
