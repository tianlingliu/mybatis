package com.thinkbit.common.rwdb;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
)})
public class DynamicDataInterceptor implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(DynamicDataInterceptor.class);
    private static final Map<String, DataSourceType> cacheMap = new ConcurrentHashMap();

    public DynamicDataInterceptor() {
    }

    public Object intercept(Invocation invocation) throws Throwable {
        boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
        if (!synchronizationActive) {
            Object[] objects = invocation.getArgs();
            MappedStatement mappedStatement = (MappedStatement)objects[0];
            DataSourceType dataSourceType = this.getDataSourceType(mappedStatement);
            cacheMap.put(mappedStatement.getId(), dataSourceType);
            DataSourceHold.putDataSource(dataSourceType);
            log.debug("SqlMapper ID: [{}] From DataSource Type: [{}],SqlCommandType: [{}]", new Object[]{mappedStatement.getId(), dataSourceType.name(), mappedStatement.getSqlCommandType().name()});
        }

        return invocation.proceed();
    }

    private DataSourceType getDataSourceType(MappedStatement mappedStatement) {
        DataSourceType dataSourceType = (DataSourceType)cacheMap.get(mappedStatement.getId());
        if (dataSourceType != null) {
            return dataSourceType;
        } else if (!SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
            return DataSourceType.WRITE;
        } else {
            return mappedStatement.getId().contains("!selectKey") ? DataSourceType.WRITE : DataSourceType.READ;
        }
    }

    public Object plugin(Object target) {
        return target instanceof Executor ? Plugin.wrap(target, this) : target;
    }

    public void setProperties(Properties properties) {
    }
}

