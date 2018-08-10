package com.thinkbit.common.sharding.operation;



import com.thinkbit.common.sharding.ShardTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpdateOperation<T, U> {
    int updateById(@Param("record") T var1, @Param("shardTable") ShardTable var2);

    int updateByExample(@Param("record") T var1, @Param("example") U var2, @Param("shardTable") ShardTable var3);

    int batchUpdate(@Param("records") List<T> var1, @Param("shardTable") ShardTable var2);
}

