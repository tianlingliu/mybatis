package com.thinkbit.common.usural.operation;



public interface CrudOperation<T, OPT, K> extends InsertOperation<T>, QueryOperation<T, OPT, K>, DeleteOperation<T, OPT, K>, UpdateOperation<T, OPT, K> {
}

