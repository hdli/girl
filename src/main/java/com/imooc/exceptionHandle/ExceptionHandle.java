package com.imooc.exceptionHandle;

import com.imooc.controller.GirlController;
import com.imooc.dto.Result;
import com.imooc.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lihuidong on 2018-3-26.
 *
 * 统一处理异常
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class) //处理的异常类型
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return new Result(girlException.getCode(),e.getMessage());
        }
        logger.error("系统异常：",e);
        return new Result(-1,"未知异常");
    }
}
