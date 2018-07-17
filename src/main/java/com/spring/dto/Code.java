package com.spring.dto;

public enum Code {
    /**
     * 200 请求成功
     * 404 错误码
     * 500 错误码
     * other 其他错误码
     */
    SUCCESS_200("200"),
    ERROR_404("404"),
    ERROR_500("500"),
    ERROR_OTHER("999");

    String code;

    Code(String code) {
        this.code = code;
    }
}
