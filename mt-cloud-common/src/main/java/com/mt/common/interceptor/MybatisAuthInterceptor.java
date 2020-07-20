package com.mt.common.interceptor;


import com.mt.common.core.UserContext;
import com.mt.common.core.base.BaseEntity;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * @author motb
 * @date 2020/4/9
 * @description 在mybatis准备sql阶段填充字段值
 */
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
            setFill(ctEntity);
        }
        if (parameter instanceof HashMap) {
            HashMap map = (HashMap) parameter;
            List<BaseEntity> insertList = (ArrayList) map.get("list");
            insertList.forEach(this::setFill);
        }

    }

    private void updateFill(Object parameter) {
        if (parameter instanceof BaseEntity) {
            BaseEntity ctEntity = (BaseEntity) parameter;
            ctEntity.setUpdateTime(LocalDateTime.now().toString());
            ctEntity.setUpdateBy(UserContext.getContext().getAccount());
        }
    }

    private void setFill(BaseEntity entity) {
        entity.setCreateTime(LocalDateTime.now().toString());
        entity.setCreateBy(UserContext.getContext().getAccount());
        entity.setUpdateTime(LocalDateTime.now().toString());
        entity.setUpdateBy(UserContext.getContext().getAccount());
    }
}
