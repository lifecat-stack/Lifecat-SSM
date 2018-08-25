package com.ten.dto;

/**
 * controller response object
 *
 * @author Administrator
 */
public class ResponseResult {
    /**
     * 状态码
     */
    private Integer statusCode;
    /**
     * 响应信息
     */
    private String responseMessage;
    /**
     * 响应对象
     */
    private Object responseData;

    /**
     * success without data object
     */
    public ResponseResult() {
        this.statusCode = 200;
        this.responseMessage = "success";
    }

    /**
     * success
     *
     * @param responseData 返回JSON对象
     */
    public ResponseResult(Object responseData) {
        this.statusCode = 200;
        if (responseData == null) {
            responseData = "json date is null";
        }
        this.responseData = responseData;
    }

    /**
     * error
     *
     * @param statusCode      错误码
     * @param responseMessage 错误信息
     */
    public ResponseResult(int statusCode, String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "response@{" +
                "statusCode:" + statusCode +
                ",responseMessage:" + responseMessage +
                ",responseData:" + responseData +
                "}";
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
}
