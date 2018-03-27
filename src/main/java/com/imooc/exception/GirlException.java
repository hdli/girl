package com.imooc.exception;

/**
 * Created by lihuidong on 2018-3-26.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException() {
    }

    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
