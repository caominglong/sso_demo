package com.banmao.demo.controller.base;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description:
 * @author: banmao
 * @date: 2022/6/21 14:30
 */
public enum ErrorType {

    BUSINESS_ERROR("500", "系统异常"),
    SYSTEM_ERROR("501", "系统异常"),
    UN_PERMISSION("402", "未授权"),
    UN_LOGIN("401", "未登录"),
    SYSTEM_BUSY("000001", "系统繁忙，请稍后再试！"),;

    private String code;
    private String message;

    private ErrorType(String code, String message) {
        this.code = code;
        this.message = message;
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
}
