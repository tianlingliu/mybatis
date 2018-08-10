package com.thinkbit.common.usural.operation;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeleteOperation<T, OPT, K> {
    int deleteById(@Param("id") K var1);

    int deleteByExample(@Param("example") OPT var1);

    int deleteIn(@Param("records") List<T> var1);
}

