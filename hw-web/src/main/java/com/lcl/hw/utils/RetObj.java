package com.lcl.hw.utils;

/**
 * Created by Rain on 2016/12/27 17:19.
 */
public class RetObj {
    private String message;
    private boolean isSuccess;
    private Object result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
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
                "message='" + message + '\'' +
                ", isSuccess=" + isSuccess +
                ", result=" + result +
                '}';
    }
}
