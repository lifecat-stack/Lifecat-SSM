package com.ten.dto;

/**
 * JSON返回数据
 */
public class ResultModel {

    private int code;
    private String msg;
    private Object data = new Object();

    public ResultModel() {
    }

    public ResultModel(ResponseCode code, Object data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public ResultModel(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultModel error(String errorMsg){
        return new ResultModel(ResponseCode.LOGIN_ERROR.getCode(), errorMsg ,"");
    }

    @Override
    public String toString() {
        return "{" + "code=" + code + ", msg=" + msg + ", data=" + data + "}";
    }

    public int getCode() {
        return this.code;
    }

    public ResultModel setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public ResultModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public ResultModel setData(Object data) {
        this.data = data;
        return this;
    }
}
