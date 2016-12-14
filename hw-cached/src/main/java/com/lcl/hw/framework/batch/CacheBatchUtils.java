package com.lcl.hw.framework.batch;

import com.lcl.hw.framework.utils.CacheClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rain on 2016/12/13 19:20.
 */
@Component
public class CacheBatchUtils {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private CacheClient cacheBatchClient;

    public CacheBatchUtils() {
    }

    public <T> void put(String key, T value) {
        this.cacheBatchClient.put(key, value);
    }

    public <T> T get(String key) {
        return this.cacheBatchClient.get(key);
    }

    public <T> T getFromMap(String mapKey, String key) {
        return this.cacheBatchClient.getFromMap(mapKey, key);
    }

    public <T> void setToMap(String mapKey, String key, T value) {
        this.cacheBatchClient.setToMap(mapKey, key, value);
    }

    public Set getMapKeys(String mapKey) {
        return this.cacheBatchClient.getMapKeys(mapKey);
    }

    public void delete(String key) {
        this.cacheBatchClient.delete(key);
    }

    public void deleteFromMap(String mapKey, String... keys) {
        this.cacheBatchClient.deleteFromMap(mapKey, keys);
    }

    public void setAppCode(String appCode) {
        this.put("app.name", appCode);
    }

    public String getAppCode() {
        return (String)this.get("app.name");
    }

    public <T> T getFromList(String listKey, long index) {
        return this.cacheBatchClient.getFromList(listKey, index);
    }

    public <T> T setToList(String listKey, long index, T value) {
        return this.cacheBatchClient.setToList(listKey, index, value);
    }

    public <T> Long deleteFromList(String listKey, long count, T value) {
        return this.cacheBatchClient.deleteFromList(listKey, count, value);
    }

    public Long getListLength(String listKey) {
        return this.cacheBatchClient.getListLength(listKey);
    }

    public <T> List<T> subList(String listKey, long start, long end) {
        return this.cacheBatchClient.subList(listKey, start, end);
    }

    public <T> Long leftPush(String listKey, T... values) {
        return this.cacheBatchClient.leftPush(listKey, values);
    }

    public <T> Long rightPush(String listKey, T... values) {
        return this.cacheBatchClient.rightPush(listKey, values);
    }

    public <T> T leftPop(String listKey) {
        return this.cacheBatchClient.leftPop(listKey);
    }

    public <T> T leftPop(String listKey, int timeout) {
        return this.cacheBatchClient.leftPop(listKey, timeout);
    }

    public <T> T rightPop(String listKey) {
        return this.cacheBatchClient.rightPop(listKey);
    }

    public <T> T rightPop(String listKey, int timeout) {
        return this.cacheBatchClient.rightPop(listKey, timeout);
    }

    public Long expire(String key, long timeout, TimeUnit unit) {
        return this.cacheBatchClient.expire(key, timeout, unit);
    }

    public void startBatch() {
        ((CacheBatchClient)this.cacheBatchClient).startBatch();
    }

    public void endBatch() {
        ((CacheBatchClient)this.cacheBatchClient).endBatch();
    }

    public void releaseResource() {
        ((CacheBatchClient)this.cacheBatchClient).releaseResource();
    }

    public Map getResultMap() {
        return ((CacheBatchClient)this.cacheBatchClient).getResultMap();
    }

    public List getResultList() {
        return ((CacheBatchClient)this.cacheBatchClient).getResultList();
    }
}
