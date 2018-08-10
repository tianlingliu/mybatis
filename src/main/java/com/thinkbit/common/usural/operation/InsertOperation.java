package com.thinkbit.common.usural.operation;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsertOperation<T> {
    long insert(@Param("record") T var1);

    int batchInsert(@Param("records") List<T> var1);

    int batchInsertOnDuplicateKey(@Param("records") List<T> var1);
}

