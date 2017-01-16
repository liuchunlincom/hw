package com.lcl.hw.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by Rain on 2017/1/5 13:54.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {

    public int id() default -1;
    public String name() default "";
    public String address() default "";
}
