package com.tiiaan.tbm.metaj.exception;

import com.tiiaan.tbm.metaj.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //@ExceptionHandler(RuntimeException.class)
    //public Result handleRuntimeException(RuntimeException e) {
    //    log.error(e.toString(), e);
    //    return Result.fail(ECode.SERVER_ERROR);
    //}


    /**
     * 服务器请求分发异常处理
     * @param e
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public Result handleServletException(Exception e) {
        log.warn("请求分发异常[{}][{}]", ErrorEnum.SERVLET_ERROR.getCode(), e.getMessage());
        return Result.fail(ErrorEnum.SERVLET_ERROR);
    }




    /**
     * 参数绑定异常
     * @param e
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException e) {
        log.warn("参数绑定异常[{}][{}]", ErrorEnum.BIND_ERROR.getCode(), e.getMessage());
        return Result.fail(ErrorEnum.BIND_ERROR);
    }




    /**
     * 数据校验异常处理
     * @param e
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e) {
        log.warn("数据校验异常[{}][{}]", ErrorEnum.VALID_ERROR.getCode(), wrapperBindingResult(e.getBindingResult()));
        return Result.fail(ErrorEnum.VALID_ERROR);
    }

    private String wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();
        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(":");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());
        }
        return msg.toString();
    }


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        log.warn("数据库异常[{}][请勿重复提交][{}]", ErrorEnum.DO_NOT_SUBMIT_FOR_MANY_TIMES.getCode(), e.getMessage());
        return Result.fail(ErrorEnum.DO_NOT_SUBMIT_FOR_MANY_TIMES);
    }


    /**
     * 业务异常处理
     * @param e
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @ExceptionHandler(FooException.class)
    public Result handleFooException(FooException e) {
        log.warn("业务异常[{}][{}]", e.getCode(), e.getMsg());
        return Result.fail(e.getCode(), e.getMsg());
    }


}
