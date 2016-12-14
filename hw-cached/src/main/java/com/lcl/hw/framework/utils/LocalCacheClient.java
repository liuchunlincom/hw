package com.lcl.hw.framework.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rain on 2016/12/13 19:41.
 */
public class LocalCacheClient extends AbstractCacheClient {
    private ConcurrentHashMap cache = new ConcurrentHashMap();

    public LocalCacheClient() {
    }

    public void init() {
    }

    public <T> void put(String key, T value) {
        this.cache.put(this.getKey(key), value);
    }

    public <T> T get(String key) {
        return (T) this.cache.get(this.getKey(key));
    }

    public void delete(String key) {
        this.cache.remove(this.getKey(key));
    }

    public <T> T getFromMap(String mapKey, String key) {
        Map map = (Map)this.get(this.getKey(mapKey));
        return map == null?null: (T) map.get(key);
    }

    public <T> void setToMap(String mapKey, String key, T value) {
        Object map = (Map)this.get(this.getKey(mapKey));
        if(map == null) {
            map = new ConcurrentHashMap();
        }

        ((Map)map).put(key, value);
        this.put(this.getKey(mapKey), map);
    }

    public Set getMapKeys(String mapKey) {
        return this.cache.keySet();
    }

    public void deleteFromMap(String mapKey, String... keys) {
        Map map = (Map)this.get(this.getKey(mapKey));
        String[] var4 = keys;
        int var5 = keys.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String key = var4[var6];
            map.remove(key);
        }

        this.put(this.getKey(mapKey), map);
    }

    public <T> T getFromList(String listKey, long index) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> T setToList(String listKey, long index, T value) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> Long deleteFromList(String listKey, long count, T value) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public Long getListLength(String listKey) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> List<T> subList(String listKey, long start, long end) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> Long leftPush(String listKey, T... values) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> Long rightPush(String listKey, T... values) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> T leftPop(String listKey) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> T leftPop(String listKey, int timeout) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> T rightPop(String listKey) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> T rightPop(String listKey, int timeout) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public Long expire(String key, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException("Unsupported method");
    }
}

