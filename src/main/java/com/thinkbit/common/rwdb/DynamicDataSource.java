package com.thinkbit.common.rwdb;



import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.Assert;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private Object writeDataSource;
    private Object readDataSource;

    public DynamicDataSource() {
    }

    public void afterPropertiesSet() {
        Assert.notNull(this.writeDataSource, "Property 'writeDataSource' is required");
        this.setDefaultTargetDataSource(this.writeDataSource);
        Map<Object, Object> targetDataSources = new HashMap();
        targetDataSources.put(DataSourceType.WRITE.name(), this.writeDataSource);
        if (this.readDataSource != null) {
            targetDataSources.put(DataSourceType.READ.name(), this.readDataSource);
        }

        this.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = DataSourceHold.getDataSource();
        return dataSourceType != null && dataSourceType != DataSourceType.WRITE ? DataSourceType.READ.name() : DataSourceType.WRITE.name();
    }

    public void setWriteDataSource(Object writeDataSource) {
        this.writeDataSource = writeDataSource;
    }

    public void setReadDataSource(Object readDataSource) {
        this.readDataSource = readDataSource;
    }
}

