package com.thinkbit.common.usural.operation;



import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpdateOperation<T, OPT, K> {
    int updateById(@Param("record") T var1);

    int updateByExample(@Param("record") T var1, @Param("example") OPT var2);

    int batchUpdate(@Param("records") List<T> var1);
}

