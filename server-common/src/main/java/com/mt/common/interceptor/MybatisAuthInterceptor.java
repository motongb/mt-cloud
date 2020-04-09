package com.mt.common.interceptor;


import com.mt.common.core.BaseEntity;
import com.mt.common.core.UserContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Properties;

/**
 * @author motb
 * @date 2020/4/9
 * @description 在mybatis准备sql阶段填充字段值
 */
@ConfigurationProperties
@Component
@Intercepts({
        @Signature(method = "query", type = Executor.class, args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(method = "update", type = Executor.class, args = {MappedStatement.class, Object.class})})
public class MybatisAuthInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];

        if (SqlCommandType.INSERT.equals(mappedStatement.getSqlCommandType())) {
            this.insertFill(parameter);
        }
        if (SqlCommandType.UPDATE.equals(mappedStatement.getSqlCommandType())) {
            this.updateFill(parameter);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private void insertFill(Object parameter) {
        if (parameter instanceof BaseEntity) {
            BaseEntity ctEntity = (BaseEntity) parameter;
            ctEntity.setCreateTime(LocalDateTime.now().toString());
            ctEntity.setCreateBy(UserContext.getContext().getAccount());
            ctEntity.setUpdateTime(LocalDateTime.now().toString());
            ctEntity.setUpdateBy(UserContext.getContext().getAccount());
        }
    }

    private void updateFill(Object parameter) {
        if (parameter instanceof BaseEntity) {
            BaseEntity ctEntity = (BaseEntity) parameter;
            ctEntity.setUpdateTime(LocalDateTime.now().toString());
            ctEntity.setUpdateBy(UserContext.getContext().getAccount());
        }
    }

}
