package com.mt.auth.service;

import com.mt.common.entity.auth.vo.LoginInfo;

import java.util.Map;

/**
 * @author motb
 * @date 2020/8/26 10:30
 * @description //TODO LoginService
 **/
public interface LoginService {

    Map<String, Object> login(LoginInfo loginInfo);
}
