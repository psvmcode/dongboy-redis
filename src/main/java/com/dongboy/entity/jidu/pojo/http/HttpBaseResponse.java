package com.dongboy.entity.jidu.pojo.http;

import cn.hutool.http.HttpBase;

/**
 * @Author dongboy
 * @what time    2023/4/13 22:21
 */
public class HttpBaseResponse {

    HttpResponseStatus responseStatus;

    private String errorMessage;

    private String responseString;

    public boolean isSuccess() {
        return this.responseStatus == HttpResponseStatus.SUCCESS;
    }

    public HttpBaseResponse() {
    }

    public HttpBaseResponse(HttpResponseStatus responseStatus, String errorMessage, String responseString) {
        this.responseStatus = responseStatus;
        this.errorMessage = errorMessage;
        this.responseStatus = responseStatus;
    }

    public HttpResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }

}
