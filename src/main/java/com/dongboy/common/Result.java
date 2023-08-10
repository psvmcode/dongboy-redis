package com.dongboy.common;

/**
 * @author dong boy
 * @date 2022年09月13日 13:18
 */

public class Result<T> {

    private Boolean status;

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(true, 200, "成功", data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(true, 200, message, data);
    }

    public static <T> Result<T> failed(Integer errorCode) {
        return new Result<T>(false, errorCode, "失败", null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> Result<T> failed(Integer errorCode, String message) {
        return new Result<T>(false, errorCode, message, null);
    }

    public static <T> Result<T> failed(String message) {
        return new Result<T>(false, 1001, message, null);
    }

    public Result() {
    }

    public Result(Boolean status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

}
