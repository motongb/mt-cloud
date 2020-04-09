package com.mt.common.interceptor;

import com.mt.common.core.CodeEnum;
import com.mt.common.core.MTConst;
import com.mt.common.core.UserContext;
import com.mt.common.exception.SysException;
import com.mt.common.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author motb
 * @date 2020/3/25 22:44
 * @description: 鉴权拦截器
 */
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    /**
     * 进入controller之前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws SysException
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws SysException {
        String token = request.getHeader(MTConst.TOKEN_KEY);
        log.info("token=={}", token);
        if (StringUtils.isEmpty(token)) {
            throw new SysException(CodeEnum.TOKEN_EMPTY);
        }
        //设置用户缓存
        UserContext.setContext(JwtUtils.checkJwt(token));
        return true;
    }

    /**
     * 请求处理完成，视图渲染之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //清除用户缓存
        UserContext.clear();
    }
}
