package com.lcl.hw.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by Rain on 2017/1/5 15:23.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelField {
    //标题
    public String title() default "";
    //0:居中 1：左对齐 2：右对齐
    public int aligin() default 0;
}
