package com.tiiaan.tbm.metaj.dto;

import com.tiiaan.tbm.metaj.exception.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Boolean success;
    private String code;
    private String msg;
    private Object data;

    public static Result ok(){
        return new Result(true, null, null, null);
    }

    public static Result ok(Object data){
        return new Result(true, null, null, data);
    }

    public static Result ok(List<?> data){
        return new Result(true, null, null, data);
    }

    public static Result fail(String code, String msg){
        return new Result(false, code, msg, null);
    }

    public static Result fail(ErrorEnum errorEnum){
        return new Result(false, errorEnum.getCode(), errorEnum.getMsg(), null);
    }

}
