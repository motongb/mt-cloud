package com.mt.common.utils;

import com.mt.common.core.CodeEnum;
import com.mt.common.core.SystemConst;
import com.mt.common.entity.base.UserEntity;
import com.mt.common.exception.SysException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author motb
 * @date 2020/3/25 20:41
 * @description: Jwt 工具类
 */
public abstract class JwtUtils {

    /**
     * 主题
     */
    private static final String SUBJECT = "motb";

    /**
     * 秘钥
     */
    private static final String SECRET_KEY = "motb8888";

    /**
     * 过期时间，毫秒，一周
     */
    private static final long EXPIRE = 1000 * 60 * 60 * 24 * 7L;


    /**
     * 创建token
     *
     * @param userEntity
     * @return
     */
    public static String createJwt(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        Map<String, Object> params = new HashMap<>();
        params.put(SystemConst.USER_INFO, userEntity);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .addClaims(params)
                .setSubject(SUBJECT)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .compact();
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static UserEntity checkJwt(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return JsonUtils.object2Bean(claims.get(SystemConst.USER_INFO), UserEntity.class);
        } catch (MalformedJwtException e) {
            throw new SysException(CodeEnum.TOKEN_INVALID);
        }
    }
}
