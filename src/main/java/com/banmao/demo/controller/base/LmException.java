package com.banmao.demo.controller.base;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description:
 * @author: banmao
 * @date: 2022/6/21 14:46
 */
public class LmException extends RuntimeException{

    private final String errorMessage;
    private final int httpCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public LmException(String errorMessage, int httpCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpCode = httpCode;
    }

    public LmException(Throwable cause, String errorMessage, int httpCode) {
        super(errorMessage, cause);
        this.errorMessage = errorMessage;
        this.httpCode = httpCode;
    }
}
