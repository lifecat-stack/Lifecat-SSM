package com.ten.dto;

/**
 * 响应信息 [状态码, 状态信息]
 */
public enum ResponseCode {
    // 0 SUCCESS
    OK(0, "成功"),

    // 1xx 验证错误
    LOGIN_ERROR(100,"账号密码错误"),

    // 4xx 客户端错误
    CLIENT_ERROR(400, "请求错误"),
    PARAM_ERROR(401, "参数错误"),

    // 5xx 服务器错误
    SERVER_ERROR(500, "服务器错误"),
    DATABASE_ERROR(501, "数据库错误");

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
