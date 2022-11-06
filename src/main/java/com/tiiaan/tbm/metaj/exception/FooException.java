package com.tiiaan.tbm.metaj.exception;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */


public class FooException extends RuntimeException {

    private String code;
    private String msg;

    public FooException() {
        super();
    }

    public FooException(IErrorEnum errorEnum) {
        super(errorEnum.getCode());
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
    }


    public FooException(IErrorEnum errorEnum, Throwable t) {
        super(errorEnum.getCode(), t);
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
    }

    public FooException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public FooException(String code, String msg) {
        super(code);
        this.code = code;
        this.msg = msg;
    }

    public FooException(String code, String msg, Throwable t) {
        super(code, t);
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
