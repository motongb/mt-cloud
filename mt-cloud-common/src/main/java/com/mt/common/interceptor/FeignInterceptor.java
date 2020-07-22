package com.mt.common.interceptor;

import com.mt.common.core.SystemConst;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: motb
 * @date: 2020/4/27 16:51
 * @description:
 */
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(attributes, "feign error");
        HttpServletRequest request = attributes.getRequest();
        requestTemplate.header(SystemConst.TOKEN_KEY, request.getHeader(SystemConst.TOKEN_KEY));
    }
}
