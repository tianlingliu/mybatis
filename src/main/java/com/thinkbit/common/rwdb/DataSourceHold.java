package com.thinkbit.common.rwdb;


public class DataSourceHold {
    private static final ThreadLocal<DataSourceType> holder = new ThreadLocal();

    private DataSourceHold() {
    }

    public static void putDataSource(DataSourceType dataSource) {
        holder.set(dataSource);
    }

    public static DataSourceType getDataSource() {
        return (DataSourceType)holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
    }
}

