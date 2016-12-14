package com.lcl.hw.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rain on 2016/12/13 19:36.
 */
@Component
public class CacheUtils {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Date startupTime = new Date();
    @Resource
    private CacheClient cacheClient;

    public CacheUtils() {
    }

    public Date getStartupTime() {
        return this.startupTime;
    }

    public <T> void put(String key, T value) {
        this.cacheClient.put(key, value);
    }

    public <T> T get(String key) {
        return this.cacheClient.get(key);
    }

    public void setMap(String mapKey, Map<String, String> map) {
        this.cacheClient.setMap(mapKey, map);
    }

    public Map getMap(String mapKey) {
        return this.cacheClient.getMap(mapKey);
    }

    public <T> T getFromMap(String mapKey, String key) {
        return this.cacheClient.getFromMap(mapKey, key);
    }

    public <T> void setToMap(String mapKey, String key, T value) {
        this.cacheClient.setToMap(mapKey, key, value);
    }

    public Set getMapKeys(String mapKey) {
        return this.cacheClient.getMapKeys(mapKey);
    }

    public void delete(String key) {
        this.cacheClient.delete(key);
    }

    public void deleteFromMap(String mapKey, String... keys) {
        this.cacheClient.deleteFromMap(mapKey, keys);
    }

    public void setAppCode(String appCode) {
        this.put("app.name", appCode);
    }

    public String getAppCode() {
        return (String)this.get("app.name");
    }

    public <T> T getFromList(String listKey, long index) {
        return this.cacheClient.getFromList(listKey, index);
    }

    public <T> T setToList(String listKey, long index, T value) {
        return this.cacheClient.setToList(listKey, index, value);
    }

    public <T> Long deleteFromList(String listKey, long count, T value) {
        return this.cacheClient.deleteFromList(listKey, count, value);
    }

    public Long getListLength(String listKey) {
        return this.cacheClient.getListLength(listKey);
    }

    public <T> List<T> subList(String listKey, long start, long end) {
        return this.cacheClient.subList(listKey, start, end);
    }

    public <T> Long leftPush(String listKey, T... values) {
        return this.cacheClient.leftPush(listKey, values);
    }

    public <T> Long rightPush(String listKey, T... values) {
        return this.cacheClient.rightPush(listKey, values);
    }

    public <T> T leftPop(String listKey) {
        return this.cacheClient.leftPop(listKey);
    }

    public <T> T leftPop(String listKey, int timeout) {
        return this.cacheClient.leftPop(listKey, timeout);
    }

    public <T> T rightPop(String listKey) {
        return this.cacheClient.rightPop(listKey);
    }

    public <T> T rightPop(String listKey, int timeout) {
        return this.cacheClient.rightPop(listKey, timeout);
    }

    public Long expire(String key, long timeout, TimeUnit unit) {
        return this.cacheClient.expire(key, timeout, unit);
    }

    public void init() {
        this.setConfigNameList(new ArrayList());
        this.setConfigValueMap(new HashMap());
    }

    public void setConfigNameList(List<String> configList) {
        this.put("config.name.list", configList);
    }

    public List<String> getConfigNameList() {
        return (List)this.get("config.name.list");
    }

    public void setConfigValueMap(Map<String, String> configValueMap) {
        this.put("config.value.map", configValueMap);
    }

    public Map<String, String> getConfigValueMap() {
        return (Map)this.get("config.value.map");
    }

    public String getConfig(String name) {
        return (String)this.getConfigValueMap().get(name);
    }

    public void addConfig(String key, String value) {
        List configNameList = this.getConfigNameList();
        Map configValueMap = this.getConfigValueMap();
        if(!configNameList.contains(key)) {
            configNameList.add(key);
            this.setConfigNameList(configNameList);
        }

        configValueMap.put(key, value);
        this.setConfigValueMap(configValueMap);
    }

    public void addConfig(Properties properties) {
        List configNameList = this.getConfigNameList();
        Map configValueMap = this.getConfigValueMap();
        Enumeration keys = properties.keys();

        while(keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = properties.getProperty(key);
            if(!configNameList.contains(key) || configValueMap.get(key) == null) {
                configNameList.add(key);
                configValueMap.put(key, value);
            }
        }

        this.setConfigNameList(configNameList);
        this.setConfigValueMap(configValueMap);
    }
}

