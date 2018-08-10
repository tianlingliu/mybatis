package com.thinkbit.common.sharding.operation;


public interface CrudOperation<T, U, K> extends InsertOperation<T>, DeleteOperation<T, U, K>, UpdateOperation<T, U>, QueryOperation<T, U, K> {
}

