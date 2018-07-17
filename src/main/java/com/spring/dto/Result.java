package com.spring.dto;

/**
 * 返回给前端的json数据信息
 *
 * @date 2018/7/17
 * @auther ten
 */
public class Result<T> {
    /**
     * 请求是否成功
     */
    private boolean success;
    /**
     * 状态码 :enum类
     */
    private Code code;
    /**
     * 错误信息 :非必填
     */
    private String errorMsg;
    /**
     * json数据体
     */
    private T jsonData;

    public Result() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getJsonData() {
        return jsonData;
    }

    public void setJsonData(T jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String toString() {
        return "{" +
                "success:" + success +
                ",errormsg:" + errorMsg +
                ",code:" + code +
                ",data:" + jsonData;
    }
}
