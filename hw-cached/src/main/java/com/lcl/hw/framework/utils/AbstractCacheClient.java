package com.lcl.hw.framework.utils;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Rain on 2016/12/13 19:34.
 */
public abstract class AbstractCacheClient implements CacheClient {
    @Resource
    private KeyUtils keyUtils;

    public AbstractCacheClient() {
    }

    public String getPrefix() {
        return this.keyUtils.getPrefix();
    }

    public String getKey(String key) {
        return this.keyUtils.getKey(key);
    }

    public void setMap(String mapKey, Map<String, String> map) {
    }

    public Map getMap(String mapKey) {
        return null;
    }
}
