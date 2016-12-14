package com.lcl.hw.framework.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rain on 2016/12/13 19:28.
 */
public interface CacheClient {
    void init();

    <T> void put(String var1, T var2);

    <T> T get(String var1);

    void delete(String var1);

    Set getMapKeys(String var1);

    <T> T getFromMap(String var1, String var2);

    <T> void setToMap(String var1, String var2, T var3);

    void setMap(String var1, Map<String, String> var2);

    Map getMap(String var1);

    void deleteFromMap(String var1, String... var2);

    <T> Long leftPush(String var1, T... var2);

    <T> Long rightPush(String var1, T... var2);

    <T> T leftPop(String var1);

    <T> T leftPop(String var1, int var2);

    <T> T rightPop(String var1);

    <T> T rightPop(String var1, int var2);

    <T> T getFromList(String var1, long var2);

    <T> T setToList(String var1, long var2, T var4);

    <T> Long deleteFromList(String var1, long var2, T var4);

    Long getListLength(String var1);

    <T> List<T> subList(String var1, long var2, long var4);

    Long expire(String var1, long var2, TimeUnit var4);
}

