package com.banmao.demo.controller.base;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Company: 杭州领图信息科技有限公司
 * 统一的返回实体
 * @description:
 * @author: banmao
 * @date: 2022/6/21 14:15
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    public static final String SUCCESSFUL_CODE = "200";
    public static final String SUCCESSFUL_MESG = "操作成功";
    private String code;
    private String message;
    private String timestamp;
    private Integer pageCount;
    private Long totalCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result(ErrorType errorType) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = df.format(LocalDateTime.now());
    }

    public Result(ErrorType errorType, T data) {
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
        this.data = data;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = df.format(LocalDateTime.now());
    }

    public static Result success(Object data) {
        return new Result("200", "操作成功", data);
    }

    public static Result success() {
        return success(true);
    }

    public static Result fail() {
        return new Result(ErrorType.SYSTEM_ERROR);
    }

    public static Result fail(String code, String message) {
        return new Result(code, message, "");
    }

    public static Result fail(ErrorType errorType, Object data) {
        return new Result(errorType, data);
    }

    public static Result fail(LmException exception) {
        return new Result(exception.getHttpCode() + "", exception.getErrorMessage(), "");
    }

    public static Result fail(ErrorType errorType, String message, Object data) {
        return new Result(errorType.getCode(), message, data);
    }

    public static Result fail(ErrorType errorType) {
        return fail(errorType,  null);
    }

    public static Result fail(Object data) {
        return new Result(ErrorType.SYSTEM_ERROR, data);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "200".equals(this.code);
    }

    @JsonIgnore
    public boolean isFail() {
        return !this.isSuccess();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
