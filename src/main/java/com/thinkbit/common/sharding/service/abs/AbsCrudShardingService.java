package com.thinkbit.common.sharding.service.abs;


import com.thinkbit.common.page.Page;
import com.thinkbit.common.sharding.ShardTable;
import com.thinkbit.common.sharding.operation.CrudOperation;
import com.thinkbit.common.sharding.service.CrudShardingService;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

public abstract class AbsCrudShardingService<Dao extends CrudOperation<T, OPT, K>, T, OPT, K> implements CrudShardingService<T, OPT, K> {
    @Resource
    protected Dao dao;

    public AbsCrudShardingService() {
    }

    public int insert(@Param("record") T record, @Param("shardTable") ShardTable shardTable) {
        return this.dao.insert(record, shardTable);
    }

    public int updateById(@Param("record") T record, @Param("shardTable") ShardTable shardTable) {
        return this.dao.updateById(record, shardTable);
    }

    public int deleteById(@Param("id") K id, @Param("shardTable") ShardTable shardTable) {
        return this.dao.deleteById(id, shardTable);
    }

    public T selectById(@Param("id") K id, @Param("shardTable") ShardTable shardTable) {
        return this.dao.selectById(id, shardTable);
    }

    public int batchInsert(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable) {
        return this.dao.batchInsert(records, shardTable);
    }

    public int updateByExample(@Param("record") T record, @Param("example") OPT example, @Param("shardTable") ShardTable shardTable) {
        return this.dao.updateByExample(record, example, shardTable);
    }

    public int deleteByExample(@Param("example") OPT example, @Param("shardTable") ShardTable shardTable) {
        return this.dao.deleteByExample(example, shardTable);
    }

    public List<T> selectByExample(@Param("example") OPT example, @Param("shardTable") ShardTable shardTable) {
        return this.dao.selectByExample(example, shardTable);
    }

    public int batchInsertOnDuplicateKey(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable) {
        return this.dao.batchInsertOnDuplicateKey(records, shardTable);
    }

    public int deleteIn(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable) {
        return this.dao.deleteIn(records, shardTable);
    }

    public int batchUpdate(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable) {
        return this.dao.batchUpdate(records, shardTable);
    }

    public T selectOneByExample(@Param("example") OPT example, @Param("shardTable") ShardTable shardTable) {
        return this.dao.selectOneByExample(example, shardTable);
    }

    public List<T> selectIn(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable) {
        return this.dao.selectIn(records, shardTable);
    }

    public int countByPager(@Param("pager") Page pager, @Param("example") OPT example, @Param("shardTable") ShardTable shardTable) {
        return this.dao.countByPager(pager, example, shardTable);
    }

    public List<T> selectByPager(@Param("pager") Page pager, @Param("example") OPT example, @Param("shardTable") ShardTable shardTable) {
        return this.dao.selectByPager(pager, example, shardTable);
    }

    public int countByExample(@Param("example") OPT example, @Param("shardTable") ShardTable shardTable) {
        return this.dao.countByExample(example, shardTable);
    }
}

