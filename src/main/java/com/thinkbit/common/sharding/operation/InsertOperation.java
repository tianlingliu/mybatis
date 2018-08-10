package com.thinkbit.common.sharding.operation;



import com.thinkbit.common.sharding.ShardTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsertOperation<T> {
    int insert(@Param("record") T var1, @Param("shardTable") ShardTable var2);

    int batchInsert(@Param("records") List<T> var1, @Param("shardTable") ShardTable var2);

    int batchInsertOnDuplicateKey(@Param("records") List<T> var1, @Param("shardTable") ShardTable var2);
}

