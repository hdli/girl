package com.imooc.dto;

/**
 * http 请求返回的最外层的对象
 * Created by lihuidong on 2018-3-26.
 */
public class Result<T> {
    /*应答码   1 ：有误   0 ：成功*/
    private Integer code;

    /*提示信息*/
    private String message;

    /*具体的内容 有误时返回null*/
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
