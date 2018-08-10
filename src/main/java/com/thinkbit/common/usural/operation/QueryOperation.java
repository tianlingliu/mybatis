package com.thinkbit.common.usural.operation;


import com.thinkbit.common.page.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QueryOperation<T, OPT, K> {
    T selectById(@Param("id") K var1);

    List<T> selectByExample(@Param("example") OPT var1);

    T selectOneByExample(@Param("example") OPT var1);

    List<T> selectIn(@Param("records") List<T> var1);

    int countByPager(@Param("pager") Page var1, @Param("example") OPT var2);

    List<T> selectByPager(@Param("pager") Page var1, @Param("example") OPT var2);

    int countByExample(@Param("example") OPT var1);
}
