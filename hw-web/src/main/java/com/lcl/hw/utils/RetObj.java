package com.lcl.hw.utils;

/**
 * Created by Rain on 2016/12/27 17:19.
 */
public class RetObj {
    //查询是否成功标志
    private boolean isSuccess;
    //返回前台成功/失败提示信息
    private String message;
    //原始异常信息
    private String exceptionMsg;
    //返回结果
    private Object result;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RetObj{" +
                "isSuccess=" + isSuccess +
                ", message='" + message + '\'' +
                ", exceptionMsg='" + exceptionMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
