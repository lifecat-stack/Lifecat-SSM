package com.spring.exception;

/**
 * controller exception info
 *
 * @author Administrator
 */
public class ErrorInfo {
    /**
     * 状态码
     */
    private int statusCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    public ErrorInfo(int statusCode, String errorMsg) {
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
