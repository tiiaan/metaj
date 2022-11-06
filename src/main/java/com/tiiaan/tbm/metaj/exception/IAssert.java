package com.tiiaan.tbm.metaj.exception;

import org.springframework.util.Assert;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public interface IAssert {

    FooException newException();
    FooException newException(Throwable t);


    default void assertNotNull(Object obj) {
        if (obj == null) {
            throw newException();
        }
    }

    default void assertIsFalse(boolean expression) {
        if (expression) {
            throw newException();
        }
    }

    default void assertIsFalse(Boolean expression) {
        if (Boolean.TRUE.equals(expression)) {
            throw newException();
        }
    }


    default void assertIsTrue(boolean expression) {
        if (!expression) {
            throw newException();
        }
    }

    default void assertIsTrue(Boolean expression) {
        if (Boolean.FALSE.equals(expression)) {
            throw newException();
        }
    }

    default void assertFail() {
        throw newException();
    }

}
