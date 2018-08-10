package com.thinkbit.common.usural.service;

import com.thinkbit.common.usural.operation.DeleteOperation;
import com.thinkbit.common.usural.operation.InsertOperation;
import com.thinkbit.common.usural.operation.QueryOperation;
import com.thinkbit.common.usural.operation.UpdateOperation;

public interface CrudService<T, OPT, K> extends QueryOperation<T, OPT, K>, InsertOperation<T>, DeleteOperation<T, OPT, K>, UpdateOperation<T, OPT, T> {
}

