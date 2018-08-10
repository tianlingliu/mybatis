package com.thinkbit.common.usural.service.abs;


import com.thinkbit.common.page.Page;
import com.thinkbit.common.usural.operation.CrudOperation;
import com.thinkbit.common.usural.service.CrudService;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

public abstract class AbsCrudService<Dao extends CrudOperation<T, OPT, K>, T, OPT, K> implements CrudService<T, OPT, K> {
    @Resource
    protected Dao dao;

    public AbsCrudService() {
    }

    public long insert(T record) {
        return this.dao.insert(record);
    }

    public T selectById(K id) {
        return this.dao.selectById(id);
    }

    public int deleteById(@Param("id") K id) {
        return this.dao.deleteById(id);
    }

    public int updateById(@Param("record") T record) {
        return this.dao.updateById(record);
    }

    public int batchInsert(@Param("records") List<T> records) {
        return this.dao.batchInsert(records);
    }

    public int deleteByExample(@Param("example") OPT example) {
        return this.dao.deleteByExample(example);
    }

    public int updateByExample(@Param("record") T record, @Param("example") OPT example) {
        return this.dao.updateByExample(record, example);
    }

    public List<T> selectByExample(@Param("example") OPT example) {
        return this.dao.selectByExample(example);
    }

    public int batchInsertOnDuplicateKey(@Param("records") List<T> records) {
        return this.dao.batchInsertOnDuplicateKey(records);
    }

    public int deleteIn(@Param("records") List<T> records) {
        return this.dao.deleteIn(records);
    }

    public int batchUpdate(@Param("records") List<T> records) {
        return this.dao.batchUpdate(records);
    }

    public T selectOneByExample(@Param("example") OPT example) {
        return this.dao.selectOneByExample(example);
    }

    public List<T> selectIn(@Param("records") List<T> records) {
        return this.dao.selectIn(records);
    }

    public int countByPager(@Param("pager") Page pager, @Param("example") OPT example) {
        return this.dao.countByPager(pager, example);
    }

    public List<T> selectByPager(@Param("pager") Page pager, @Param("example") OPT example) {
        return this.dao.selectByPager(pager, example);
    }

    public int countByExample(@Param("example") OPT example) {
        return this.dao.countByExample(example);
    }
}

