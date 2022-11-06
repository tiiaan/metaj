package com.tiiaan.tbm.metaj.exception;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public interface IFooExceptionAssert extends IAssert, IErrorEnum {

    @Override
    default FooException newException() {
        return new FooException(this);
    }

    @Override
    default FooException newException(Throwable t) {
        return new FooException(this, t);
    }

}
