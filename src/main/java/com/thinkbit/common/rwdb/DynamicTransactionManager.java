package com.thinkbit.common.rwdb;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

public class DynamicTransactionManager extends DataSourceTransactionManager {
    public DynamicTransactionManager() {
    }

    public DynamicTransactionManager(DataSource dataSource) {
        super(dataSource);
    }

    protected void doBegin(Object transaction, TransactionDefinition definition) {
        boolean readOnly = definition.isReadOnly();
        if (readOnly) {
            DataSourceHold.putDataSource(DataSourceType.READ);
        } else {
            DataSourceHold.putDataSource(DataSourceType.WRITE);
        }

        super.doBegin(transaction, definition);
    }

    protected void doCleanupAfterCompletion(Object transaction) {
        super.doCleanupAfterCompletion(transaction);
        DataSourceHold.clearDataSource();
    }
}

