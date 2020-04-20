package com.mt.base.service;

import com.mt.common.entity.sys.UserEntity;
import com.mt.common.entity.vo.LoginInfo;
import com.mt.common.utils.JwtUtils;
import org.springframework.stereotype.Service;

/**
 * @author motb
 * @date 2020/3/25 21:51
 * @description:
 */
@Service
public class LoginService {

    public String login(LoginInfo loginInfo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAccount("motb");
        userEntity.setName("motb");
        userEntity.setPassword("123456");
        return JwtUtils.createJwt(userEntity);
    }
}
