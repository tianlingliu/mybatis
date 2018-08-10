package com.thinkbit.common.sharding.operation;



import com.thinkbit.common.page.Page;
import com.thinkbit.common.sharding.ShardTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QueryOperation<T, U, K> {
    T selectById(@Param("id") K var1, @Param("shardTable") ShardTable var2);

    List<T> selectByExample(@Param("example") U var1, @Param("shardTable") ShardTable var2);

    T selectOneByExample(@Param("example") U var1, @Param("shardTable") ShardTable var2);

    List<T> selectIn(@Param("records") List<T> var1, @Param("shardTable") ShardTable var2);

    int countByPager(@Param("pager") Page var1, @Param("example") U var2, @Param("shardTable") ShardTable var3);

    List<T> selectByPager(@Param("pager") Page var1, @Param("example") U var2, @Param("shardTable") ShardTable var3);

    int countByExample(@Param("example") U var1, @Param("shardTable") ShardTable var2);
}

