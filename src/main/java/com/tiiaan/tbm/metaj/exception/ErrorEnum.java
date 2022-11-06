package com.tiiaan.tbm.metaj.exception;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public enum ErrorEnum implements IFooExceptionAssert {

    //01 系统
    SERVER_ERROR("01001", "服务器异常"),
    SERVLET_ERROR("01002", "请求分发异常"),
    BIND_ERROR("01003", "参数绑定异常"),
    VALID_ERROR("01004", "数据校验异常"),
    //02 用户模块
    USER_NOT_FOUND("02001", "用户未注册"),
    INVALID_PASSWORD("02002", "密码错误"),

    UPLOAD_ERROR("03001", "图片上传失败"),
    INVALID_FILENAME("03002", "图片名称错误"),

    DB_UPDATE_FAIL("05001", "数据库更新失败");


    private String code;
    private String msg;


    ErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
