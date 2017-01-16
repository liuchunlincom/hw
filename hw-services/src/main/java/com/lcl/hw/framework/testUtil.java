package com.lcl.hw.framework;

import com.lcl.hw.framework.annotation.TestAnnotation;

import java.lang.reflect.Field;

/**
 * Created by Rain on 2017/1/5 15:11.
 */
public class testUtil {
    public static void getUserInfo(Class<?> clazz){
        String userName=" 水果名称：";
        String userAddr=" 水果颜色：";
        String userId="供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for(Field field :fields){
            if(field.isAnnotationPresent(TestAnnotation.class)){
                TestAnnotation fruitProvider= (TestAnnotation) field.getAnnotation(TestAnnotation.class);
                userId=" 用户编号："+fruitProvider.id()+" 用户名称："+fruitProvider.name()+" 用户地址："+fruitProvider.address();
                System.out.println(userId);
            }
        }
    }

    public static void main(String[] args) {
        testUtil.getUserInfo(Test.class);
    }
}
