package com.lcl.hw.framework;

import com.lcl.hw.framework.annotation.ExcelField;
import com.lcl.hw.framework.annotation.TestAnnotation;

import java.util.Timer;

/**
 * Created by Rain on 2017/1/5 15:08.
 */
public class Test {
    @TestAnnotation(name="Rain",address="中国香港",id=11011)
    private String user;

    @ExcelField(title = "用户姓名",aligin = 0)
    public String getUser() {
        return user;
    }



    public void setUser(String user) {
        this.user = user;
    }
}
