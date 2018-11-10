package com.ten.dto;

/**
 * 响应信息 [状态码, 状态信息]
 */
public enum ResponseCode {
    /**
     * status code
     */
    OK(0, "成功"),

    // 未登陆，或登陆失效
    LOGIN_ERROR(-1, "请重新登陆"),

    // 1xx 网络错误
    ERROR(100, "请求错误"),

    // 5xx 服务器错误
    SERVER_ERROR(500, "服务器错误");

    private final int code;
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response@{code:" + code + ",msg:" + msg + "}";
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
