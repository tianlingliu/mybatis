package com.thinkbit.common.sharding.operation;



import com.thinkbit.common.sharding.ShardTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeleteOperation<T, U, K> {
    int deleteById(@Param("id") K var1, @Param("shardTable") ShardTable var2);

    int deleteByExample(@Param("example") U var1, @Param("shardTable") ShardTable var2);

    int deleteIn(@Param("records") List<T> var1, @Param("shardTable") ShardTable var2);
}

